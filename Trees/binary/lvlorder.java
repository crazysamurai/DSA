public void levelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    
    if(root == null) return;
    
    q.add(root);
    q.add(null); //important
    
    while(!q.isEmpty()){
        TreeNode curr = q.poll();
        
        if(curr==null){ //this loop helps in determining the change in level 
            if(q.isEmpty()) return;
            System.out.println("");
            q.add(null);
        }else{
            System.out.println(curr.val+" ");
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }      
        }  
    }
    return;
}