//gfg: https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem

class Solution {
    public int perfectSum(int arr[], int n, int sum) {
        // Your code goes here
        int mod = (int) (1e9 + 7); // given in problem, not necessary in the standard code
        int dp[][] = new int[n + 1][sum + 1];

        // standard code would be this but there's a test case where one of the elements
        // in the array is 0, due to which when the asked sum is 0 and available
        // elements != 0, there would be two subsets: {empty} and {0} instead of just 1,
        // so we will not fill the rest of the rows only the first row where available
        // elements == 0
        // for(int i = 0; i<n+1; i++){
        // for(int j = 0; j<sum+1; j++){
        // if(i == 0) dp[i][j] = 0;
        // if(j == 0) dp[i][j] = 1;
        // }
        // }

        for (int j = 0; j < sum + 1; j++) {
            dp[0][j] = 0;
        }

        dp[0][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) { // notice the loope starts from 0 for j
                if (arr[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j - arr[i - 1]] % mod + dp[i - 1][j] % mod) % mod; // notice we need to add
                                                                                             // the number of picks and
                                                                                             // not picks generated
                                                                                             // subsets
                } else {
                    dp[i][j] = dp[i - 1][j] % mod;
                }
            }
        }
        return dp[n][sum];
    }
}