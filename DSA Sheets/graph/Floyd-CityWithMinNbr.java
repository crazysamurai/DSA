//lc:https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
//yt: https://youtu.be/PwMVNSJ5SLI?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn

// We need to determine the shortest distance between each node in the graph and
// then pick the node with least number of neighbours at a distance less or
// equal to the distanceThreshold.

// This is one of the graph problems where we can apply Floyd Warshall or
// Dijkstra algorithms to get the result.

// Solving it with Dijkstra might result in a better time complexity.

import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        // creating the distance matrix
        int[][] matrix = new int[n][n];
        for (int[] arr : matrix) {
            Arrays.fill(arr, (int) 1e9);// fill it with a large value so that it can be replaced later with a smaller
                                        // value
        }

        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;// self distance is zero
        }

        // main loop
        for (int k = 0; k < n; k++) { // k is the node through which we need to travel to get to node j
            for (int i = 0; i < n; i++) { // src node
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]); // which is the shorter distance
                                                                                        // b/w two neighbours, the
                                                                                        // direct one or via some other
                                                                                        // node k
                }
            }
        }

        int city = -1; // city with least neighbours
        int nebr = n; // number of neighbours

        for (int i = 0; i < n; i++) {
            int currNebr = 0; // number of neighbours of city i
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= distanceThreshold)
                    currNebr++; // count the number of neighbours that are at a distance <= distance threshold
            }
            if (nebr >= currNebr) {
                nebr = currNebr;
                city = i;
            }
        }

        return city;
    }
}