class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
         
        int j = 0;
        int len = pushed.length;
        for(int i = 0; i<len; i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && popped[j] == st.peek()){
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}