class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int ans[] = new int[adjacentPairs.length + 1];
        //create a graph from the matrix given,  we store the nodes along with their adj nodes int the hash map
        for(int i = 0; i<adjacentPairs.length; i++){
                if(!hm.containsKey(adjacentPairs[i][0])){
                    hm.put(adjacentPairs[i][0], new ArrayList<>());
                }
                hm.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            
            if(!hm.containsKey(adjacentPairs[i][1])){
                    hm.put(adjacentPairs[i][1], new ArrayList<>());
                }
                hm.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        
        //we need to find the starting node to traverse the graph and that node should only have one edge, i.e. it should have only 1 adj val
        int start = 0;
        for(int key : hm.keySet()){
            if(hm.get(key).size() == 1)
                {start = key;
                break;}
        }
        
        //for traversing the array here we are using dfs, bfs can also be used
        Set<Integer> vis = new HashSet<>();
        ArrayList<Integer> ls = new ArrayList<>();
        
        dfs(vis, ls, hm, start);
        for(int i = 0; i<ls.size(); i++){
            ans[i] = ls.get(i);
        }
        
        // System.out.println(hm);
        return ans;
    }
    
    private void dfs(Set<Integer> vis, List<Integer>ls, Map<Integer, List<Integer>>hm, int node){
        ls.add(node);
        vis.add(node);
        
        List<Integer> adj= hm.get(node);
        
        for(Integer adjNode: adj){
            if(!vis.contains(adjNode)){
                dfs(vis, ls, hm, adjNode);
            }
        }
    }    
}