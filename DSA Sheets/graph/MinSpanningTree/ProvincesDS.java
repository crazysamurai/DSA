//yt:https://www.youtube.com/watch?v=ZGr5nX-Gi6Y&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=47

import java.util.*;

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds = new DisjointSet(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1)
                    ds.unionBySize(i, j);
            }
        }
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (ds.parent.get(i) == i)
                count++;
        }
        return count;
    }
};

// disjoint set class here