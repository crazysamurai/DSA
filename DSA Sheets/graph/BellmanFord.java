//gfg: https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-from-the-source-bellman-ford-algorithm
//yt: https://www.youtube.com/watch?v=0vVofAhAYjc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=42

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
import java.util.*;

class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int dis[] = new int[V];
        Arrays.fill(dis, (int) 1e8);
        dis[S] = 0;

        // loop n-1 times
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> ls : edges) {
                int u = ls.get(0);
                int v = ls.get(1);
                int w = ls.get(2);

                if (dis[u] != (int) 1e8 && dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                }
            }
        }

        // loop nth time to check for -ve cycle
        for (ArrayList<Integer> ls : edges) {
            int u = ls.get(0);
            int v = ls.get(1);
            int w = ls.get(2);

            if (dis[u] + w < dis[v]) {
                return new int[] { -1 };
            }
        }
        return dis;
    }
}
// TC: V*E
// SC: V