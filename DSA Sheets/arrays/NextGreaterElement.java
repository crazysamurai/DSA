class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int ans [] = new int [n];
        
        //to form a cycle in the array, we can just imagine that it was copied again when the original array ended,  
     //  0 1 2 3 4 || 5 6 7 8 9
     // [1,2,3,4,3 || 1,2,3,4,3]
    //now we can't just increase the array size or create a new one so we'll run the loop for 2*the length of array and for all the indices >= n we'll take the modulus with arr.length to get the valid index
        
        for(int i = 2*n-1; i>=0; i--){
            int idx = 0;
            if(i>=n) idx = i%n;
            else idx = i;
            
            while(!st.isEmpty() && st.peek()<=nums[idx]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                ans[idx] = st.peek();
            }else{
                ans[idx] = -1;   
            }
            
            st.push(nums[idx]);
        }
        return ans;
    }
}
//https://www.youtube.com/watch?v=Du881K7Jtk8&t=602s