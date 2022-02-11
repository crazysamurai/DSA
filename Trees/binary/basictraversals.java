//inorder Left Root Right
class Solution {
    List<Integer> ls = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return ls;
        inorderTraversal(root.left);
        ls.add(root.val);
        inorderTraversal(root.right);
        return ls;
    }
}

//preorder Root Left Right
class Solution {
    List<Integer> ls = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return ls;
        ls.add(root.val);
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        return ls;
    }
}


//postorder Left Right Root
class Solution {
    List<Integer> ls = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return ls;
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        ls.add(root.val);
        return ls;
    }
}