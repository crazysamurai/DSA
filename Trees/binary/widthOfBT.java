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
    public int widthOfBinaryTree(TreeNode root) {
        int [] max = new int [2];
        int width = 0;
        traverse(root, max, 0);
        for(int i = 0; i<max.length; i++){
            System.out.println(max[i]);
        }
        return width = max[1]-max[0]+1;
    }
    
    public void traverse(TreeNode root, int[] max, int lvl){
        if(root==null) return;
        
        max[0]=Math.min(max[0], lvl);
        max[1]=Math.max(max[1], lvl);
        
        traverse(root.left, max, lvl-1);
        traverse(root.right, max, lvl+1);
        
    }

}