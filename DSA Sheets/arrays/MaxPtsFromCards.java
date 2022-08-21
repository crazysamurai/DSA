class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int tsum = 0;
        int n = cardPoints.length;
        //find the total sum of the array
        for(int val : cardPoints){
            tsum+=val;
        }
        
        int wsize = n-k;
        int l = 0;
        int r = wsize-1;
        int sum = 0;
        //find the sum of the window
        for(int i = l; i<r+1; i++){
            sum+=cardPoints[i];
        }
        //find the diff b/w the total sum and window sum
        int diff = tsum-sum;
        int max = diff;
        
        //loop through the array sliding window way
        while(r<n-1){
            sum-=cardPoints[l];// decrease the val of removed elt from the sum
            r++;
            l++;
            sum+=cardPoints[r];// add the val of the new elt in the sum
            diff = tsum - sum; //find the new diff b/w the total sum and new sum
            max = Math.max(diff, max);
        }
        
        return max;
    }
}