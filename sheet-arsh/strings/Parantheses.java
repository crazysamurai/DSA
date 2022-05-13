class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if (curr == '(' || curr == '[' || curr == '{') {
                st.push(curr);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    char pop = st.pop();
                    if (pop == '(' && curr == ')')
                        continue;
                    else if (pop == '[' && curr == ']')
                        continue;
                    else if (pop == '{' && curr == '}')
                        continue;
                    else
                        return false;
                }
            }
        }
        if (!st.isEmpty())
            return false;
        return true;
    }
}
// https://leetcode.com/problems/valid-parentheses/submissions/