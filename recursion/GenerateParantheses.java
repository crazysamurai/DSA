class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        String ans = "";
        backtracking(0, 0, n, ls, ans);
        return ls;
    }
    
    public void backtracking(int open, int close, int n, List<String> ls, String ans){
        if(close == n && open == n){
            String s = "";
            ls.add(ans);
            return;
        }
        
        if(open<n){
            backtracking(open+1, close, n, ls, ans+"(");
        }
        
        if(close<open){
            backtracking(open, close+1, n, ls, ans+")");
        }
        
        return;
    }
}
