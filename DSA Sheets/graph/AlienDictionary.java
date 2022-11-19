
//YT:https://www.youtube.com/watch?v=U3N_je7tWAs&ab_channel=takeUforward
//GFG:https://practice.geeksforgeeks.org/problems/alien-dictionary/1
import java.util.*;

class Solution {
    public String findOrder(String[] dict, int N, int K) {
        // Write your code here
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    ls.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }

        }

        int indg[] = new int[K];
        for (int i = 0; i < K; i++) {
            for (int node : ls.get(i)) {
                indg[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indg[i] == 0)
                q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.peek());
            int node = q.peek();
            q.remove();

            for (int adjNode : ls.get(node)) {
                indg[adjNode]--;
                if (indg[adjNode] == 0)
                    q.add(adjNode);
            }

        }

        String res = "";
        for (int val : ans) {
            res += (char) (val + (int) ('a'));
        }
        return res;
    }
}