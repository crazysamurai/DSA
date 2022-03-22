class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<asteroids.length; i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<asteroids[i]*-1){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == asteroids[i]*-1){
                    st.pop();
                }else if(!st.isEmpty() && st.peek() > asteroids[i]*-1){
                    
                }else{
                    st.push(asteroids[i]);
                }
            }
        }
        int arr[] = new int [st.size()];
        for(int i = arr.length-1; i>=0; i--){
            arr[i] = st.pop();
        }
        return arr;
    }
}