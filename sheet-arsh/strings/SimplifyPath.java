class Solution {
    public String simplifyPath(String path) {
        String arr[] = path.split("/");
        Stack<String> st = new Stack<>();
        String res = "";

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("..") && !st.isEmpty()) {
                st.pop();
            } else if (!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals("..")) {
                st.push(arr[i]);
            }
        }

        if (st.isEmpty())
            return "/";

        while (!st.isEmpty()) {
            res = "/" + st.pop() + res;
        }
        return res;
    }
}
// https://leetcode.com/problems/simplify-path/submissions/