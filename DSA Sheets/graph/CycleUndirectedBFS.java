class Node {
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (detCycle(vis, i, adj))
                    return true;
            }
        }
        return false;
    }

    private boolean detCycle(boolean vis[], int i, ArrayList<ArrayList<Integer>> adj) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, -1)); // add the first element and since it has no prev elt, set it as -1
        vis[i] = true;

        while (!q.isEmpty()) {
            int curr = q.peek().first; // q.peek() = <first, second>
            int prev = q.peek().second;
            q.remove(); // remove the prev node since it's not needed anymore

            for (Integer adjNode : adj.get(curr)) {
                if (vis[adjNode]) {
                    if (prev != adjNode)
                        return true; // has to be a non parent for it to be a cycle
                } else if (vis[adjNode] == false) {
                    vis[adjNode] = true;
                    q.add(new Node(adjNode, curr));
                }
            }
        }
        return false;
    }
}