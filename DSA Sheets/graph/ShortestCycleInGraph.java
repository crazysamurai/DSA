class Solution {
    public int findShortestCycle(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        int vis[] = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int[] len = new int[n];
            Arrays.fill(len, (int) 1e9);

            int[] start = new int[n];
            Arrays.fill(start, -1);

            len[i] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            while (!q.isEmpty()) {
                int x = q.poll();
                for (int adjNode : adj.get(x)) {
                    if (len[adjNode] == (int) (1e9)) {
                        len[adjNode] = 1 + len[x];
                        start[adjNode] = x;
                        q.add(adjNode);
                    } else if (start[x] != adjNode && start[adjNode] != x)
                        ans = Math.min(ans, len[x] + len[adjNode] + 1);
                }
            }
        }
        if (ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }
}