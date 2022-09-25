class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[] = new int[V];
        // int pathVis [] = new int [V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(adj, vis, i))
                    return true;
            }
        }
        return false;
    }

    // using just 1 array
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int idx) {
        vis[idx] = 2; // set 2 if visited and path visited
        for (int adjNode : adj.get(idx)) {
            if (vis[adjNode] == 0) {// if not visited, then do
                if (dfs(adj, vis, adjNode))
                    return true;
            } else if (vis[adjNode] == 2) {// if vis and path vis then cycle exists
                return true;
            }
        }
        vis[idx] = 1;// set back to just visited and not path visited during backtracking
        return false;
    }

    // using 2 arrys visted and path visited
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int pathVis[], int idx) {
        vis[idx] = 1;
        pathVis[idx] = 1;
        for (int adjNode : adj.get(idx)) {
            if (vis[adjNode] == 0) {
                if (dfs(adj, vis, pathVis, adjNode))
                    return true;
            } else if (pathVis[adjNode] == 1) {
                return true;
            }
        }
        pathVis[idx] = 0;
        return false;
    }

}