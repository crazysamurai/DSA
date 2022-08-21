class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>(); 
        String res = "";
        if(n<1) return ls;
        
        backtrack(ls, res, 0, 0, n);
        return ls;
    }
    
    private void backtrack(List<String> ls, String res, int open, int close, int n){
        if(close==n && open==n){
            ls.add(res);
            return;
        }
        if(open<n) backtrack(ls, res+"(", open+1, close, n);
        if(open>close) backtrack(ls, res+")", open, close+1, n);
    }
}

// https://leetcode.com/problems/generate-parentheses/