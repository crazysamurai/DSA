class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>(numCourses);
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int vis [] = new int [numCourses];
        int dfsvis [] = new int [numCourses];
        for(int i = 0; i<numCourses; i++){
            if(vis[i] == 0 && dfs(i, adj, vis, dfsvis)) return false;
        }
        return true;
    }
    
    public boolean dfs(int node, List<List<Integer>> adj, int [] vis, int [] dfsvis){
        vis[node] = 1;
        dfsvis[node] = 1;
        for(int adjNode: adj.get(node)){
            if(vis[adjNode] == 0){
                if(dfs(adjNode, adj, vis, dfsvis)) return true;
            }else if(dfsvis[adjNode] == 1) return true;
        }
        dfsvis[node] = 0;
        return false;
    }
    
}

//using dfs and looking for a cycle, if exists then it's not possible to complete the course