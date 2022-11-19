//https://www.youtube.com/watch?v=73sneFXuTEg
class Solution {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        Queue<Integer> q = new LinkedList<>();
        int idg[] = new int[V];// indegree array
        for (int i = 0; i < V; i++) {// this is the node from which edge starts
            for (int val : adj.get(i)) {// val is the node into which the edge goes so we'll use this as the idx for idg
                                        // arr
                idg[val]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (idg[i] == 0)
                q.add(i);
        }

        int ans[] = new int[V];
        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int adjNode : adj.get(node)) {
                idg[adjNode]--;
                if (idg[adjNode] == 0)
                    q.add(adjNode);
            }
            ans[idx] = node;
            idx++;
        }
        return ans;
    }
}


//BFS TOPOSORT
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //reverse the graph
        int V = graph.length;
        List<List<Integer>> rev = new ArrayList<>();
        for(int i = 0; i<V; i++){
            rev.add(new ArrayList<>());
        }
        int freq [] = new int [V];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<V; i++){
            freq[i] = graph[i].length;
            for(int node : graph[i]){
                rev.get(node).add(i);
            }
        }

        for(int i = 0; i<V; i++){
            if(freq[i] == 0){
                q.add(i);
            }
        }
        List<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()){
            ls.add(q.peek());
            int node = q.peek();
            q.remove();

            for(int adjNode : rev.get(node)){
                freq[adjNode]--;
                if(freq[adjNode]==0)q.add(adjNode);
            }

        }
        Collections.sort(ls);
        return ls;
    }
}