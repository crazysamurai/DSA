
//LC:https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
//yt: https://www.youtube.com/watch?v=9XybHVqTHcQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=38
import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // creating adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        int m = flights.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));// {stop, {node, dist}}
        }

        // No need to use a Heap/PQ because each node added to the queue is arranged
        // according to the number of stops .i.e 0 stops followed by 1 stops then 2
        // stops and so on
        Queue<Trio> q = new LinkedList<>();
        q.add(new Trio(0, src, 0)); // (number of stops, node, cost)

        // Array to store the best cost to reach each node
        int dis[] = new int[n];
        Arrays.fill(dis, (int) 1e9);// fill the array with big value
        dis[src] = 0;// cost to reach src is zero

        while (!q.isEmpty()) {
            Trio out = q.peek();
            int stop = out.first;
            int node = out.second;
            int dist = out.third;
            q.remove();

            if (stop > k)
                break;// if number of stops gets more than k(allowed number of stops) then we can skip
                      // the rest of the nodes

            for (Pair val : adj.get(node)) {
                int wt = val.second;
                int adjNode = val.first;

                if (wt + dist < dis[adjNode] && stop <= k) {// if the new cost i.e. weight(cost curr node to adj node) +
                                                            // dist (cost for curr node) is less than the already
                                                            // present cost in the dist array for the adjNode then
                                                            // update it with the newer lesser cost.
                    dis[adjNode] = wt + dist;
                    q.add(new Trio(stop + 1, adjNode, wt + dist));
                }
            }
        }

        if (dis[dst] == (int) 1e9)
            return -1;// unable to reach destination node
        return dis[dst];
    }
}

class Pair {
    int first, second;

    public Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

class Trio {
    int first, second, third;

    public Trio(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}