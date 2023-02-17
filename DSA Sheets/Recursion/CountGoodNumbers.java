class Solution {
    int mod = (int) (1e9) + 7;

    public int countGoodNumbers(long n) {
        // a pattern is formed 5 * 4 * 5 ..., so instead of calculating for each index
        // we can calculate the powers for n indices
        long even = power(5, (n % 2 == 0) ? n / 2 : (n / 2) + 1) % mod;
        long odd = power(4, n / 2) % mod;
        long res = 1;
        res = (res * even) % mod;
        if (odd != 0)
            res = (res * odd) % mod;
        return (int) res % mod;
    }

    public long power(long n, long p) {
        if (p == 0)
            return 1;
        long ans = power(n, p / 2) % mod;
        if (p % 2 != 0)
            return (ans * ans * n) % mod;
        return (ans * ans) % mod;
    }
}

// https://leetcode.com/problems/count-good-numbers/description/
// explanation:
// https://leetcode.com/problems/count-good-numbers/solutions/1317451/java-step-by-step-clear-explanation-with-pictures-o-logn/