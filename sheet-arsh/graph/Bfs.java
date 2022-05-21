class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean vis[] = new boolean [V]; //visited array
        ArrayList<Integer> bfs = new ArrayList<>(); //return list
        
        //this one if the graph is disconnected
        
        // for(int i = 0; i<V; i++){
        //     if(vis[i] == false){
                
        //         Queue<Integer> q = new LinkedList<>();
        //         q.add(i);
        //         vis[i] = true;
                
        //         while(!q.isEmpty()){
        //             Integer node = q.poll();
        //             bfs.add(node);
                    
        //             for(Integer adjNode : adj.get(node)){
        //                 if(vis[adjNode] == false){
        //                     vis[adjNode] = true;
        //                     q.add(adjNode);
        //                 }
        //             }
        //         }
        //     }
        // }
        
        //this for normal graph
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true; //set true so we don't traverse it again
        while(!q.isEmpty()){

            int node = q.poll();
            bfs.add(node);

            for(int adjNode : adj.get(node)){//loop through the adjacent list for each node to find it's adjacent nodes and add them to the queue
                if(!vis[adjNode]){
                    vis[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }
        return bfs;
    }
}