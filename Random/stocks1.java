class Solution {
    public int maxProfit(int[] arr) {
        int maxPro = 0;
        int min = arr[0];
        int pro = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i]<min) min = arr[i];
            pro = arr[i]-min;
            if(pro>maxPro) maxPro = pro;
        }
        
        return maxPro;
    }
}

//LC 121
//just store the min on left and sub it with following elements on right to solve the problem in 1 go for O(n).
// https://www.youtube.com/watch?v=eMSfBgbiEjk&ab_channel=takeUforward
