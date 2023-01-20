// lc:https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
// sol:https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/solutions/3033288/explained-java-solution-dfs-o-n/?orderBy=most_votes&languageTags=java

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        int vis[] = new int[n];
        for (int i = 0; i <= edges.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return dfs(adj, hasApple, 0, vis);
    }

    public int dfs(List<List<Integer>> adj, List<Boolean> hasApple, int node, int[] vis) {
        if (vis[node] == 1)
            return 0;
        vis[node] = 1;
        int time = 0;

        for (int adjNode : adj.get(node)) {
            time += dfs(adj, hasApple, adjNode, vis);
        }
        if (node == 0)
            return time;
        if (hasApple.get(node) == true || time > 0)
            return (2 + time);
        else
            return 0;
    }
}