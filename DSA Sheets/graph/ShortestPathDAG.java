//GFG: https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=direct-acyclic-graph
//YT: https://www.youtube.com/watch?v=ZUFQfFaU-8U&ab_channel=takeUforward

    class Solution {
    
        public int[] shortestPath(int N,int M, int[][] edges) {
            //Code here
            
            //creating adjacency list
            List<List<Pair>> adj = new ArrayList<>();
            for(int i = 0; i<N; i++){
                ArrayList<Pair> temp = new ArrayList<Pair>();
                adj.add(temp);
            }
            //adding edges and weights into list
            for(int i = 0; i<M; i++){//note the loop runs till number of edges
                int u = edges[i][0];//starting node
                int v = edges[i][1];//adjnode
                int wt = edges[i][2];//edge weight from u->v
                adj.get(u).add(new Pair(v,wt));
            }
            
            //call toposort
            int vis[] = new int [N];
            Stack<Integer> st = new Stack<>();
            for(int i = 0; i<N; i++){
                if(vis[i] == 0){
                    toposort(vis, st, adj, i);
                }
            }
            
            //creating a distance array and fill it with infinite values
            int dis[] = new int [N];
            Arrays.fill(dis, (int)(1e9));
            
            dis[0] = 0;//distance of source node
            
            while(!st.isEmpty()){
                int node = st.peek();
                st.pop();
                
                for(int i = 0; i<adj.get(node).size(); i++){
                    int v = adj.get(node).get(i).first;
                    int wt = adj.get(node).get(i).second;
                    
                    if(dis[node] + wt < dis[v]){
                        dis[v] = dis[node] + wt;
                    }
                }
            }
            
            for (int i = 0;i < N;i++)
            if (dis[i] == 1e9) dis[i] = -1; //if we are unable to reach the destination retuurn -1
            return dis;
            
        }
        
        //toposort function
        public void toposort(int [] vis, Stack<Integer> st, List<List<Pair>> adj, int node){
            vis[node] = 1;
            for(int i = 0; i<adj.get(node).size(); i++){
                int v = adj.get(node).get(i).first;//navigating the adj list to get the adjnode from the pairs
                if(vis[v] == 0){
                    toposort(vis, st, adj, v);
                }
            }
            st.push(node);
        }
        
    }
    
    class Pair{
        int first, second;
        Pair(int _first, int _second){
            this.first = _first;
            this.second = _second;
        }
    }