public class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        fun(0, target, list, ans, candidates);
        return ans;
    }
    
    public void fun(int i, int target, ArrayList<Integer> list, List<List<Integer>> ans, int [] arr){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        if(target>=arr[i]){
            list.add(arr[i]);
            fun(i, target-arr[i], list, ans, arr);
            // list.remove(list.size()-1);
            list.remove(Integer.valueOf(arr[i]));// we can't remoove the element directly by .remove(arr[i])
        }
        fun(i+1, target, list, ans, arr);
    }
}

//lc 39
