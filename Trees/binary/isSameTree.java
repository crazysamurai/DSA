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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return(p==q);
        } //handles if either of them is a null value
        if(p.val==q.val) return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));//if the values are same we move to the next nodes in each tree
        return false;//if we've reached here that means the nodes are different
    }
}
