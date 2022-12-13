//yt:https://www.youtube.com/watch?v=Rn6B-Q4SNyA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=50
//gfg:https://practice.geeksforgeeks.org/problems/number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-islands

import java.util.*;

class Solution {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        List<Integer> ans = new ArrayList<>();
        DisjointSet ds = new DisjointSet(rows * cols);

        int vis[][] = new int[rows][cols];
        int count = 0; // count of islands/components
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };

        for (int i = 0; i < operators.length; i++) {
            int r = operators[i][0];
            int c = operators[i][1];

            if (vis[r][c] == 1) {
                ans.add(count);
                continue;
            }

            vis[r][c] = 1;
            count++;

            for (int j = 0; j < 4; j++) {
                int nrow = r + drow[j];
                int ncol = c + dcol[j];

                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && vis[nrow][ncol] == 1) { // if a adjnode is
                                                                                                    // also an island
                    int nodeA = calcNode(r, c, cols); // convert idx to nodes so that they can be connected in ds
                    int nodeB = calcNode(nrow, ncol, cols);
                    if (ds.findParent(nodeA) != ds.findParent(nodeB)) { // if they have the same parent then they're
                                                                        // already connected, if not then we need to
                                                                        // connect them
                        ds.unionBySize(nodeA, nodeB);
                        count--;// now that the node is a part of already existing island, we have to reduce the
                                // count by 1
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }

    // calc the node number
    public int calcNode(int r, int c, int cols) {
        return r * cols + c;
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