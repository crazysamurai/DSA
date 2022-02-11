class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ls = new ArrayList<>();
        
        //preorder Root Left Right
        st.add(root);
        while(!st.isEmpty()){
            root = st.pop();
            ls.add(root.val);
            if(root.right!=null){
                st.add(root.right);
            }
            if(root.left!=null){
                st.add(root.left);
            }
        }

        //inorder left root right
        
        return ls;
    }
}
