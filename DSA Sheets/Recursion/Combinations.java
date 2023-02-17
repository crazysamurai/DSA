class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ls = new ArrayList<>();
        solve(n, k, ls);
        return ans;
    }

    public void solve(int n, int k, List<Integer> ls) {
        if (ls.size() == k) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        while (n >= 1) {
            ls.add(n);
            solve(n - 1, k, ls);
            ls.remove(ls.size() - 1);
            n--;
        }
    }
}