//gfg: https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph-having-unit-distance
//YT: https://www.youtube.com/watch?v=C4gxoTaI71U&ab_channel=takeUforward

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        //creating adj list
        for(int i = 0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        
        //dis array
        int dis[] = new int [n];
        Arrays.fill(dis, (int)(1e9));
        dis[src] = 0; //source
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            
            for(int adjNode : adj.get(node)){
                if(dis[node] + 1 < dis[adjNode]){
                    dis[adjNode] = dis[node]+1;
                    q.add(adjNode);
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            if(dis[i] == 1e9) dis[i] = -1;
        }
        return dis;
    }
}