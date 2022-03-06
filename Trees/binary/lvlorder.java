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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> store = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        
        if(root == null) return ans;
        
        store.add(root);
        store.add(null);
        
        while(!store.isEmpty()){
            TreeNode curr = store.poll();
            
            if(curr==null){
                if(store.isEmpty()){
                    ans.add(new ArrayList(ls));
                    return ans;
                }
                ans.add(new ArrayList(ls));
                ls.clear();
                store.add(null);
                continue;
            }
            
            ls.add(curr.val);
            if(curr.left!=null) store.add(curr.left);
            if(curr.right!=null)store.add(curr.right);
        }
        return ans;
    }
}