//yt:https://www.youtube.com/watch?v=FMwpt_aQOGw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=49
//lc:https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/

import java.util.*;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extra = 0;// stores the number of extra edges available
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.findParent(u) == ds.findParent(v))
                extra++; // if both have the same ultimate parent then they are already connected which
                         // would mean the loop reached them again through an extra edge
            else
                ds.unionBySize(u, v);// connecting new nodes
        }
        int count = 0;// number of components
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i)
                count++;// if a node is a parent of itself that would mean it's an ultimate parent of
                        // itself and some other nodes which would make a component
        }

        // number of edges required to connect all components in a graph = number of
        // components - 1
        if (count - 1 <= extra)
            return count - 1;
        else
            return -1;
    }
}

// Disjoint set class
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int p = findParent(parent.get(node));
        parent.set(node, p);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return;
        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pv) + size.get(pu));
        }
    }
}