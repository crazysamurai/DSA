import java.util.*;

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            dist[i] = (int) 1e9;
        }
        dist[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dis - y.dis);

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }

        pq.add(new Pair(0, 1));
        while (!pq.isEmpty()) {
            int wt = pq.peek().dis;
            int nd = pq.peek().node;
            pq.remove();
            for (Pair val : adj.get(nd)) {
                int adjNode = val.node;
                int adjDis = val.dis;
                if (dist[adjNode] > wt + adjDis) {
                    dist[adjNode] = wt + adjDis;
                    pq.add(new Pair(wt + adjDis, adjNode));
                    parent[adjNode] = nd;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (dist[n] == 1e9) {
            ans.add(-1);
            return ans;
        }
        int node = n;
        while (parent[node] != node) {
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}

class Pair {
    int node, dis;

    Pair(int _dis, int _node) {
        this.node = _node;
        this.dis = _dis;
    }
}