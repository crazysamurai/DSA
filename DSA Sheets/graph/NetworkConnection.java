//LC: https://leetcode.com/problems/number-of-operations-to-make-network-connected/

/*Steps to solve the problem: 
    
    1) Make Adjacency List -> count of Edges(E)
    2) DFS Traversal -> count of Components(C)
    3) n -> count of Nodes(N)
    4) Redundant Edges: R = E - [(N-1) - (C-1)] <--- important step
       $ When number of components is 1, formula becomes:
        R = E - [N-1]
       -For N nodes N-1 edges are required for complete connection.
        Rest will be redundant, hence the formula.
    5) Negative Cases (return -1): 
       - E<N-1  
       - R<C-1 
    6) Else return C-1 (This is the minimum number of edges required to connect C components);
    
    If you have enough redudant edges R >= C-1, then you can use C-1 edges to connect a network.
    
    */
    
    public int makeConnected(int n, int[][] connections) {
    
        /* Count of Nodes -> N */
        int N = n;  
        
        /* Count of Edges -> E */
        int E = connections.length; 
        
        int R = 0;
        int C = 0;
        
        if(E<N-1)
            return -1;
        
        /* Create Adjaceny List */
        List<List<Integer>> adj = new ArrayList<>();
        
          for(int i = 0; i<n; i++)
             adj.add(new ArrayList<>());
        
          for(int[] c : connections){
                adj.get(c[0]).add(c[1]);
                adj.get(c[1]).add(c[0]);
            }
        
        boolean[] visited = new boolean[n];
        
        /* Perform DFS traversal to count components -> C */
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(adj,visited,i);
                C++;
            }
        }
        
        /* Calculate Redundant Edges -> R */
        R = E-((N-1)-(C-1));
    
        if(R<C-1)
            return -1;
        
        return C-1;
    }
    
    /* DFS Traversal */
    public void dfs(List<List<Integer>> adj, boolean[] visited, int i){
        
        if(visited[i])
            return;
        
        visited[i] = true;
        
        List<Integer> connection = adj.get(i);
        for(int c : connection){
            if(!visited[c])
                dfs(adj,visited,c);
        }
        return;
    }
    
    }