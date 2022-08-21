class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis [] = new boolean[V];
        for(int i = 0; i<V; i++){
            if(vis[i] == false){
                if(dfs(i, vis, -1, adj)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int curr, boolean [] vis, int prev, ArrayList<ArrayList<Integer>> adj){
        vis[curr] = true;
        for(Integer adjNode : adj.get(curr)){
            if(vis[adjNode] == false){
                if(dfs(adjNode, vis, curr, adj)==true) return true;
            }else if(adjNode != prev) return true;
        }
        return false;
    }
}