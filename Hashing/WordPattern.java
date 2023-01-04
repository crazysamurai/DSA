//LC:https://leetcode.com/problems/word-pattern/description/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Boolean> word = new HashMap<>();
        String arr[] = s.split(" ");

        if (arr.length != pattern.length())
            return false;

        for (int i = 0; i < arr.length; i++) {
            char ch = pattern.charAt(i);
            if (!hm.containsKey(ch) && !word.containsKey(arr[i])) {
                hm.put(ch, arr[i]);
                word.put(arr[i], true);
            } else if (!hm.containsKey(ch) && word.containsKey(arr[i])) {
                return false;
            } else if (hm.containsKey(ch)) {
                if (!hm.get(ch).equals(arr[i]))
                    return false;
            }
        }
        return true;
    }
}