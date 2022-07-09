class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max=0;
        int vol = 0;
        
        while(l<r){
            //find the volume of each index
            vol = Math.min(height[l], height[r])*(r-l);//min height because that's the max level of water that can be stored between the two heights or it will overflow 
            max = Math.max(vol, max);
            
            if(height[l]<height[r])l++;//keep the larger height and start decreasing the pointer with smaller height inorder to maximize the volume
            else r--;
            
        }
        return max;
    }
}