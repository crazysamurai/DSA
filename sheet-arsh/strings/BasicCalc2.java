class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        char ps = '+'; // prev sign
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) { // built-in character function
                num = num * 10 + (ch - '0'); // converting to a number
            }

            if (isOps(ch) || i == s.length() - 1) {
                if (ps == '+') {
                    st.push(num);
                } else if (ps == '-') {
                    st.push(-num);
                } else if (ps == '*') {
                    int top = st.pop();
                    st.push(top * num);
                } else if (ps == '/') {
                    int top = st.pop();
                    st.push(top / num);
                }
                num = 0;
                ps = ch;
            }

        }

        int res = 0;
        while (!st.empty()) {
            res += st.pop();
        }
        return res;
    }

    private boolean isOps(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }
}