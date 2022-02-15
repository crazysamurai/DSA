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
    public int maxPathSum(TreeNode root) {
        int [] maxi = new int [1];
        maxi[0] = Integer.MIN_VALUE; //important to store the min value of integer for the test case where the tree only has -ve integers as root.val
        maxSum(root, maxi);
        return maxi[0];
    }
    
    public int maxSum(TreeNode root, int [] maxi){
        if(root==null) return 0;
        
        int left = Math.max(0, maxSum(root.left, maxi));//this will return 0 if the node value is <0 which will not give us the max sum
        int right = Math.max(0, maxSum(root.right, maxi));
        
        maxi[0] = Math.max(maxi[0], left+right+root.val);
        return root.val+Math.max(left,right);
    }
}
