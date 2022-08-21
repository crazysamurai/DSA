class Solution {

//the question is a modified version of next largest element
//watch the video for better understanding

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int leftArr [] = new int [n];
        int rightArr [] = new int [n];
        
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                leftArr[i] = st.peek() + 1;
            }else leftArr[i] = 0;
            
            st.push(i);
        }
        
        while(!st.isEmpty())st.pop();
        
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rightArr[i] = st.peek() - 1;
            }else rightArr[i] = n-1;
            
            st.push(i);
        }
        
        int ans = 0;
        for(int i = 0; i<n; i++){
            int area = heights[i] * (rightArr[i] - leftArr[i] + 1);
            ans = Math.max(area, ans);
        }
        return ans;
    }
}
//https://www.youtube.com/watch?v=X0X6G-eWgQ8&t=1587s