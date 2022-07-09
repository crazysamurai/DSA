class Solution {
    public boolean isBipartite(int[][] graph) {
        int color [] = new int [graph.length];
        Arrays.fill(color, -1);
        for(int i = 0; i<graph.length; i++){
            if(color[i]==-1){
                if(!check(i, graph, color)) return false;
            }
        }   
        return true;
    }
    
    public boolean check(int node, int [][] graph, int [] color){
        Queue <Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        
        while(!q.isEmpty()){
            int x = q.poll();
            for(int adj : graph[x]){
                if(color[adj] == -1){
                    color[adj] = 1 - color[x];
                    q.add(adj);
                }else if(color[adj] == color[x]) return false;
            }
        }
        return true;
    }
}
//https://www.youtube.com/watch?v=nbgaEu-pvkU&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=10