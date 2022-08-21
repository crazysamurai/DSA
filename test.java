import java.util.ArrayList;
import java.util.Queue;

public class test {

    public ArrayList<Integer> bfs (ArrayList<ArrayList<Integer>> adjList, start){
        Boolean [] vis = new Boolean [n];
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> bfs = new ArrayList<>();

        q.add(start);
        vis[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            for(int adjNode : adjList.get(node)){
                if(!vis[adjNode]){
                    q.add(adjNode);
                    vis[adjNode] = true;
                }
            }
        }
        return bfs;
    }

}
