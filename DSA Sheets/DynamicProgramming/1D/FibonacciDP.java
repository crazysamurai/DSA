// recursion soln
class Solution {
    public int fib(int n) {
        if (n <= 1)
            return n;
        int last = fib(n - 1);
        int slast = fib(n - 2);
        return last + slast;
    }
}
// TC:O(2^n)

// https://takeuforward.org/data-structure/dynamic-programming-introduction/
// GFG:https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1?page=1&category[]=Dynamic%20Programming&sortBy=submissions
class Solution {
    // memoization
    static long nthFibonacci(long n) {
        // code here
        int l = (int) n;// needs to be converted to int because arrays can be created in long but the
                        // index has to be in int
        long dp[] = new long[l + 1];
        Arrays.fill(dp, -1);
        return solve(dp, l) % 1000000007;// given in question to mod the return value
    }

    public static long solve(long[] dp, int l) {
        if (l <= 1)
            return l;
        if (dp[l] != -1)
            return dp[l];
        return dp[l] = solve(dp, l - 1) % 1000000007 + solve(dp, l - 2) % 1000000007;
    }
}

// tc: O(n) sc:O(n)+O(n)

// Tabulation
// LEETCODE:https://leetcode.com/problems/fibonacci-number/
class Solution {
    public int fib(int n) {
        if (n < 1)
            return 0; // boundary condition

        int[] dp = new int[n + 1];// dp array
        Arrays.fill(dp, -1);// fill with -1
        dp[0] = 0;// recursion base case converted to dp
        dp[1] = 1;// same as above
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];// recursive relation to dp
        }
        return dp[n];
    }
}
// tc:O(n) sc:O(n)

// Space Optimization
// the logic is we only need the two previous values of n to find the new value
// so why use the whole array when we can just store these two values in a
// couple of variables
class Solution {
    public int fib(int n) {
        if (n < 1)
            return 0;
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}

// sc:O(1)