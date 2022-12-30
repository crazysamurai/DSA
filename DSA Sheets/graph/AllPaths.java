//LC https://leetcode.com/problems/all-paths-from-source-to-target/description/
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(); // stores current path
        path.add(0); // adding starting idx
        dfs(graph, ans, path, 0);
        return ans;
    }

    public void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> path, int node) {
        if (node == graph.length - 1) { // reached the end
            ans.add(new ArrayList<>(path)); // add the path into answer list
            return; // move to prevoius dfs call
        }
        for (int val : graph[node]) {
            path.add(val); // add the node we are going to traverse
            dfs(graph, ans, path, val); // traverse the node
            path.remove(path.size() - 1); // when the dfs call ends we need to backtrack and look for other paths
        }
    }
}