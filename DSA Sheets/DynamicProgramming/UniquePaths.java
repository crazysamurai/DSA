//https://www.youtube.com/watch?v=BtdgAys4yMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14 
//lc: https://leetcode.com/problems/unique-paths/submissions/
class Solution {
    // Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) {
        // Your code here
        // int dp[][] = new int [a][b];
        // for(int [] val : dp){
        // Arrays.fill(val, -1);
        // }
        // tabulation
        // for(int i = 0; i<a; i++){
        // for(int j = 0; j<b; j++){

        // if(i == 0 && j == 0){
        // dp[0][0] = 1;
        // continue;
        // }

        // int up = 0;
        // int left = 0;
        // if(i>0) up = dp[i-1][j];
        // if(j>0) left = dp[i][j-1];
        // dp[i][j] = up+left;
        // }
        // }
        // return dp[a-1][b-1];

        // space optimization

        int prev[] = new int[b];
        for (int i = 0; i < a; i++) {
            int temp[] = new int[b];
            for (int j = 0; j < b; j++) {

                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[b - 1];
        // return solve(a-1, b-1, dp);

    }

    // public static int solve(int n, int m, int [][] dp){
    // if(n == 0 && m == 0) return 1;
    // if(n<0 || m<0) return 0;
    // int up = solve(n-1, m);
    // int left = solve(n, m-1);
    // return (up+left);

    // memoization
    // if(i==0&&j==0)return 1;
    // if(i<0||j<0)return 0;
    // if(dp[i][j]!=-1)return dp[i][j];

    // int up = solve(n-1, m, dp);
    // int left = solve(n, m-1, dp);
    // return dp[i][j] = up+left;
    // }

}