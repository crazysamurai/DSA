class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int vis [] = new int [V];
        Stack<Integer> st = new Stack<>();
        int res[] = new int [V];
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, st);
            }
        }
        
        for(int i = 0; i<V; i++){
            res[i] = st.pop();
        }
        
        return res;
    }
    
    static void dfs(int i, ArrayList<ArrayList<Integer>> adj, int [] vis, Stack<Integer> st){
        if(vis[i] == 1) return;
        
        vis[i] = 1;
        
        for(int adjNode : adj.get(i)){
            if(vis[adjNode] == 0){
                dfs(adjNode, adj, vis, st);
            }
        }
        st.push(i);
    }
}
// https://www.youtube.com/watch?v=Yh6EFazXipA&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=13