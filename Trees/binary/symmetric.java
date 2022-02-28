class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode ls = root;
        TreeNode rs = root;
        
        return dfs(ls,rs);
    }
    
    public boolean dfs(TreeNode ls ,TreeNode rs){
        if(ls==null || rs == null) return ls==rs;
        if(ls.val != rs.val) return false;
        return dfs(ls.right, rs.left) && dfs(ls.left, rs.right);
    }
}