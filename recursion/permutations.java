//approach 1
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<>();
        boolean [] state= new boolean[nums.length];//creating an array to see if the element is available to select or already selected
        fun(nums, 0, ls, state, ans);
        return ans;
    }
    public void fun(int[] nums, int idx, List<Integer> ls, boolean [] state, List<List<Integer>> ans){
        if(idx==nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(state[i]==false){
                state[i] = true;
                ls.add(nums[i]);
                fun(nums, idx+1, ls, state, ans);
                //important to set false and remove the value for the next recursion call, make tree to visualize and understand better
                ls.remove(ls.size()-1);
                state[i]=false;
            }
        }
    }
}
// https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12&ab_channel=takeUforward