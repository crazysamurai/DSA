package sheet.graph;

class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int pos [][] = {{-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,-1}, {2,1}, {-1,-2}, {1,-2}};
	    int vis [][] = new int [N+1][N+1];
	    vis[KnightPos[0]] [KnightPos[1]] = 1;
	    int steps = 0;
	    Queue<Pair> q= new LinkedList<>();
	    q.add(new Pair(KnightPos[0], KnightPos[1]));
	    
	    while(!q.isEmpty()){
	        int size = q.size();
	        while(size-->0){
	            int i = q.peek().first;
    	        int j = q.peek().second;
    	        q.remove();
    	        if(i == TargetPos[0] && j == TargetPos[1]){
    	            //path found
    	            return steps;
    	        }
    	        
    	        for(int x = 0; x<8; x++){
    	            int ni = i + pos[x][0];
    	            int nj = j + pos[x][1];
    	            if(ni>=1 && nj>=1 && ni<=N && nj<=N && vis[ni][nj]!=1){
    	                q.add(new Pair(ni, nj));
    	                vis[ni][nj] = 1;
    	            }
    	        }
	        }
	        steps++;
	    }
	    return -1;
    }
}

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}