import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // creating adjacency list
        /*
         * Node 0 : [(adjNode, time)],
         * Node 1 : [],
         * Node 2 : [(1,1), (3,1)],
         * Node 3 : [(4,1)],
         * Node 4 : []
         */
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = times.length;
        for (int i = 0; i < m; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        // Array to store the best time to reach each node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9); // fill the array with big value
        dist[k] = 0; // set time needed to reach source node to zero

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        pq.add(new Pair(0, k)); // (time, node)

        while (!pq.isEmpty()) {
            Pair out = pq.peek();
            int time = out.first;
            int node = out.second;
            pq.remove();

            for (Pair val : adj.get(node)) {
                int adjNode = val.first;
                int weight = val.second;
                if (weight + time < dist[adjNode]) { // if the new time i.e. weight(time from curr node to adj node) +
                                                     // time (time for curr node) is less than the already present time
                                                     // in the dist array for the adjNode then update it with the newer
                                                     // lesser time.
                    dist[adjNode] = weight + time;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        // find the maximum value from dist array
        int res = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > res)
                res = dist[i];
        }
        if (res == (int) 1e9)
            return -1;// impossible to reach all the nodes
        return res;
    }
}

class Pair {
    int first, second;

    public Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}