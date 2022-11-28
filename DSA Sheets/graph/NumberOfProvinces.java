import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // converting the adj matrix into list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int vis[] = new int[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, vis, adj);
            }
        }
        return count;
    }

    public void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] != 1) {
                dfs(adjNode, vis, adj);
            }
        }
    }

}