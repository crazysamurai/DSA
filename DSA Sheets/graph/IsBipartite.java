//https://www.youtube.com/watch?v=-vu34sct1g8
//LC: https://leetcode.com/problems/is-graph-bipartite/submissions/

//BFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        // color array
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        // for multiple components
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, i, color))
                    return false;
                // if(!dfs(graph, i, color, 0)) return false;
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph, int idx, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        color[idx] = 1;// strat with a color either 0 or 1
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adj : graph[node]) {
                if (color[adj] == -1) {// if the node is not colored yet
                    color[adj] = 1 - color[node];// this will color the node in opposite color
                    q.add(adj);
                } else if (color[adj] == color[node])
                    return false;// if the node is already colored and the color is same as that to the adj node
            }
        }
        return true; // if the traversal is complete without any problems, then the graph/component
                     // is colored/is bipartite
    }

    // dfs
    public boolean dfs(int[][] graph, int idx, int[] color, int col) {
        color[idx] = col;
        for (int adj : graph[idx]) {
            if (color[adj] == -1) {
                if (!dfs(graph, adj, color, 1 - col))
                    return false;
            } else if (color[adj] == color[idx])
                return false;
        }
        return true;
    }

}
