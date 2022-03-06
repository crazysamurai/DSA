class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int ans [] = new int [n];
        
        for(int i = n-1; i>=0; i--){
            //here the temperature is not found
            while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]){
                st.pop();
            }
            //here the next greater temp is found
            if(!st.isEmpty()){
                ans[i] = st.peek()-i;
            }
            //we need to put all the temperatures in the stack at some point
            st.push(i);
        }
        return ans;
    }
}