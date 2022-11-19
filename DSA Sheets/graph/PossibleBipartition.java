import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int color[] = new int[n + 1];
        Arrays.fill(color, -1);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // creating the adjacency list

        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());

        for (int[] dis : dislikes) {
            graph.get(dis[0]).add(dis[1]);
            graph.get(dis[1]).add(dis[0]);
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !dfs(i, graph, color))
                return false;
        }
        return true;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, int[] color) {
        if (color[node] == -1)
            color[node] = 1;
        for (int adj : graph.get(node)) {
            if (color[adj] == -1) {
                color[adj] = 1 - color[node];
                if (!dfs(adj, graph, color))
                    return false;
            } else if (color[adj] == color[node])
                return false;
        }
        return true;
    }
}