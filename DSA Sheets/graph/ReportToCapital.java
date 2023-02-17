class Solution {
    private long cost = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0, -1, seats, adj);

        // System.out.println(adj);
        return cost;
    }

    private int dfs(int node, int parent, int seats, List<List<Integer>> adj) {
        int rep = 1;
        for (int child : adj.get(node)) {
            if (child != parent) {
                rep += dfs(child, node, seats, adj);
            }
        }
        if (node != 0) {
            cost += (rep + seats - 1) / seats;
        }

        return rep;
    }
}
// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/description/
// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/solutions/3176516/java-dfs-explained/