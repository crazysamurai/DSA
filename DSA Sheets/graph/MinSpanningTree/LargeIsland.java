//yt:https://www.youtube.com/watch?v=lgiz0Oup6gM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=51
//lc:https://leetcode.com/problems/making-a-large-island/description/

import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int drow[] = { -1, 0, 1, 0 }; // directions row
        int dcol[] = { 0, 1, 0, -1 }; // directions col

        DisjointSet ds = new DisjointSet(n * n); // create a disjoint set of size n*n because of total n*n nodes in the
                                                 // graph

        // Part 1: Identify the islands in the grid and form a disjoint set from them
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue; // skip if current cell has zero because it's not a part of any island

                for (int k = 0; k < 4; k++) {
                    int nrow = drow[k] + i; // new row
                    int ncol = dcol[k] + j; // new col

                    if (isValid(nrow, ncol, n, grid)) {
                        int nodeA = calcNode(i, j, n); // current node
                        int nodeB = calcNode(nrow, ncol, n); // the adjacent node
                        ds.unionBySize(nodeA, nodeB); // unite the nodes which would form an island or add the current
                                                      // node to the already existing island
                    }

                }

            }
        }

        /*
         * Part 2: Now we have all the islands in ds and their sizes are stored in the
         * ds.size.
         * One by one visit each cell that has zero in the grid and check if it can be
         * connected to some adjacent island.
         * If connection is possible we will get the ultimate parent node in that island
         * and store it in the hashset.
         * Why hashset? to eliminate the possibility of connecting to the same island
         * more than once.
         * Once we're done with this, traverse the hashset and get the size of each
         * island using the ultimate parent and add them.
         */
        int maxIsland = 0; // max size
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    flag = false;
                    HashSet<Integer> hs = new HashSet<>(); // hashset to store the ultimate parents of islands
                    for (int k = 0; k < 4; k++) {
                        int nrow = drow[k] + i;
                        int ncol = dcol[k] + j;
                        if (isValid(nrow, ncol, n, grid)) {
                            int node = calcNode(nrow, ncol, n); // adjacent node
                            int pnode = ds.findParent(node); // ultimate parent node of current node
                            hs.add(pnode);
                        }
                    }
                    int currIsland = 0; // curr island size
                    for (Integer val : hs)
                        currIsland += ds.size.get(val); // loop the hashset and get the current island size
                    maxIsland = Math.max(maxIsland, currIsland + 1);
                }
            }
        }

        if (flag)
            return n * n; // if there is no cell with zero then there is only one island of the size n*n
                          // i.e whole grid is an island
        return maxIsland;
    }

    // calculating the node number
    public int calcNode(int r, int c, int cols) {
        return r * cols + c;
    }

    // validating if the newly generated cell
    public boolean isValid(int nrow, int ncol, int n, int[][] grid) {
        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1)
            return true;
        return false;
    }
}

// disjoint set class
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