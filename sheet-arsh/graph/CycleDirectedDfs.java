class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[] = new int [V];
        int dfsVis[] = new int [V];
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                if(dfs(i, vis, dfsVis, adj))return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int node, int [] vis, int [] dfsVis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        dfsVis[node] = 1;
        
        for(Integer adjNode : adj.get(node)){
            if(vis[adjNode] == 0){
                if(dfs(adjNode, vis, dfsVis, adj) == true) return true;
            }else if(dfsVis[adjNode] == 1) return true;
        }
        
        dfsVis[node] = 0;
        return false;
    }
}