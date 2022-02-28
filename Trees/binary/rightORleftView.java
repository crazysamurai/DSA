/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        dfs(ls, root, 0);
        return ls;
    }
    
    public void dfs(List<Integer> ls, TreeNode root, int lvl){
        if(root == null) return;
        if(ls.size()==lvl) ls.add(root.val);
        dfs(ls,root.right,lvl+1);
        dfs(ls,root.left,lvl+1);//swap the two for left view
        return;
    }
}