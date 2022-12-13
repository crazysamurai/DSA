//yt:https://www.youtube.com/watch?v=qrAub5z8FeA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=54
//lc:https://leetcode.com/problems/critical-connections-in-a-network/description/

import java.util.*;

class Solution {
    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> ls : connections) {
            int u = ls.get(0);
            int v = ls.get(1);
            adj.get(v).add(u);
            adj.get(u).add(v);
        }

        int vis[] = new int[n];
        int time[] = new int[n];
        int lowest[] = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, vis, adj, time, lowest, bridges);
        return bridges;
    }

    public void dfs(int node, int parent, int[] vis, List<List<Integer>> adj, int[] time, int[] lowest,
            List<List<Integer>> bridges) {
        vis[node] = 1;
        time[node] = lowest[node] = timer;
        timer++;

        for (int adjNode : adj.get(node)) {
            if (adjNode == parent)
                continue;
            if (vis[adjNode] == 0) {
                dfs(adjNode, node, vis, adj, time, lowest, bridges);
                lowest[node] = Math.min(lowest[node], lowest[adjNode]);
                if (lowest[adjNode] > time[node])
                    bridges.add(Arrays.asList(adjNode, node));
            } else
                lowest[node] = Math.min(lowest[node], lowest[adjNode]);
        }
    }
}