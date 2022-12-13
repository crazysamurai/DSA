//yt: https://www.youtube.com/watch?v=R6uoSjZ2imo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=53
//gfg:https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=strongly-connected-components-kosarajus-algo

import java.util.*;

class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0)
                dfs(i, vis, adj, st);
        }

        ArrayList<ArrayList<Integer>> adjR = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjR.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            for (int node : adj.get(i)) {
                adjR.get(node).add(i);
            }
        }

        int count = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == 0) {
                dfsR(node, vis, adjR);
                count++;
            }
        }

        return count;
    }

    public void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] == 0) {
                dfs(adjNode, vis, adj, st);
            }
        }
        st.push(node);
    }

    public void dfsR(int node, int[] vis, ArrayList<ArrayList<Integer>> adjR) {
        vis[node] = 1;
        for (int adjNode : adjR.get(node)) {
            if (vis[adjNode] == 0) {
                dfsR(adjNode, vis, adjR);
            }
        }
    }
}