class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length != cost.length) return -1;
        
        int gsum = 0;
        int csum = 0;
        
        for(int i = 0; i<gas.length; i++){
            gsum+=gas[i];
            csum+=cost[i];
        }
        
        if(gsum<csum) return -1;//we can't complete the trip if the cost is more than the available gas
        
        int i = 0, sum = 0, idx = 0;
        while(i<gas.length){
            sum+=(gas[i]-cost[i]);
            if(sum<0){
                sum = 0;
                idx = i+1;
            }
            i++;
        }
       return idx; 
    }
}
//https://www.youtube.com/watch?v=lJwbPZGo05A&t=438s
