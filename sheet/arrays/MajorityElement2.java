class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int c1 =0;
        int c2 = 0;
        int a1 = -1;
        int a2 = -1;
        
        for(int val : nums){
            if(val == a1) c1++;
            else if(val == a2) c2++;
            else if(c1 == 0){
                a1 = val;
                c1 = 1;
            }else if(c2 == 0){
                a2 = val;
                c2 = 1;
            }else{
                c1--;
                c2--;
            }
        }
        
        c1=0; c2=0;
        for(int val : nums){
            if(val == a1)c1++;
            else if(val ==a2)c2++;
        }
        
        if(c1>nums.length/3) ls.add(a1);
        if(c2>nums.length/3) ls.add(a2);
        
        return ls;
    }
}
//https://www.youtube.com/watch?v=yDbkQd9t2ig