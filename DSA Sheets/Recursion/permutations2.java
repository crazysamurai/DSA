class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<>();
        boolean [] state= new boolean[nums.length];
        HashSet<List> hs = new HashSet<>(); 
        fun(nums, 0, ls, state, ans, hs);
        return ans;
    }
    public void fun(int[] nums, int idx, List<Integer> ls, boolean [] state, List<List<Integer>> ans, HashSet<List> hs){
        if(idx==nums.length && !hs.contains(ls)){
            hs.add(new ArrayList<>(ls));
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(state[i]==false){
                state[i] = true;
                ls.add(nums[i]);
                fun(nums, idx+1, ls, state, ans,hs);
                ls.remove(ls.size()-1);
                state[i]=false;
            }
        }
    }
}
