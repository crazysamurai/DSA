class Solution {
    public String reverseWords(String s) {
        int i = s.length() - 1; // loop from the back
        StringBuilder res = new StringBuilder(); // because we have to update the string inside a loop

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ')
                i--; // handling the spaces

            int j = i;
            if (i < 0)
                break;// handling spaces in the beginning of the string

            while (i >= 0 && s.charAt(i) != ' ')
                i--; // traversing the individual string

            if (res.isEmpty()) {
                res.append(s.substring(i + 1, j + 1)); // when there is no other word, we don't have to add a space
            } else {
                res.append(" " + s.substring(i + 1, j + 1));
            }
        }
        return res.toString(); // converting stringbuilder obj to string
    }
}