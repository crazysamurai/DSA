class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / solve(x, -n);
        }
        return solve(x, n);
    }

    public double solve(double x, int n) {
        if (n == 0)
            return 1;
        double val = solve(x, n / 2); // if we need to find x^4 we can do it as x^2*x^2 rather than x*x*x*x, which
                                      // would reduce the complexity from O(n) to O(logn)
        if (n % 2 == 0)
            return val * val;
        return val * val * x;
    }
}
// https://leetcode.com/problems/powx-n/description/