class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.dist - y.dist);
        int dis[] = new int [V];//creating distance array
        Arrays.fill(dis, (int)(1e9));
        
        dis[S] = 0;
        pq.add(new Pair(0,S));
        
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();
            
            for(int i = 0; i<adj.get(node).size(); i++){
                int wt = adj.get(node).get(i).get(1);//weight of edge to the adj node
                int nd = adj.get(node).get(i).get(0);//adj node
                
                if(wt+dist < dis[nd]){ //comparing the current distance in the array and the (distance from source + weight)
                    dis[nd] = wt+dist;
                    pq.add(new Pair(dis[nd], nd));//if we get a new smaller distance we need to push the node & dist pair into the pq
                }
            }
        }
        return dis;
    }
}

class Pair{
    int node, dist;
    Pair(int _dist, int _node){
        this.node = _node;
        this.dist = _dist;
    }
}