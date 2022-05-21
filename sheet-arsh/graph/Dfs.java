class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> store = new ArrayList<>();
        boolean vis [] = new boolean [V];
        
        //if it was a disconnected graph
        // for(int i = 0; i<V; i++){
        //  if(vis[i] == false) dfs(i, vis, store, adj);
        // }
        
        dfs(0, vis, store, adj);
        return store;
    }
    
    public void dfs(int node, boolean [] vis, ArrayList<Integer> store, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        store.add(node);
        for(int adjNode : adj.get(node)){
            if(vis[adjNode] == false){
                dfs(adjNode, vis, store, adj);
            }
        }
    }
}
