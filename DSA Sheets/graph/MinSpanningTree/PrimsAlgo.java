//gfg: https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
//yt: https://www.youtube.com/watch?v=mJcZjjKzeqk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=44

import java.util.*;

class Solution {
    // Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // Add your code here
        int sum = 0; // sum of mst

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        pq.add(new Pair(0, 0));// {weight, node}

        int[] vis = new int[V];
        // List<Pair> mst = new ArrayList<>(); //only if we need the tree path as well

        while (!pq.isEmpty()) {
            Pair top = pq.peek();
            int wt = top.first;
            int node = top.second;
            pq.remove();

            if (vis[node] == 1)
                continue;

            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(adjWt, adjNode));
                }
            }
        }
        return sum;
    }
}

class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
