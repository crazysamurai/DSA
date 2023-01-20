//lc: https://leetcode.com/problems/make-number-of-distinct-characters-equal/description/
//sol: https://leetcode.com/problems/make-number-of-distinct-characters-equal/solutions/3016762/my-accepted-o-26-26-m-n-solution/

class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (char ch : word1.toCharArray())
            f1[ch - 'a']++;
        for (char ch : word2.toCharArray())
            f2[ch - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (f1[i] == 0)
                continue;
            for (int j = 0; j < 26; j++) {
                if (f2[j] == 0)
                    continue;

                f1[i]--;
                f2[i]++;
                f1[j]++;
                f2[j]--;

                if (same(f1, f2))
                    return true;

                f1[i]++;
                f2[i]--;
                f1[j]--;
                f2[j]++;
            }
        }
        return false;
    }

    private boolean same(int[] f1, int[] f2) {
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < 26; i++) {
            if (f1[i] > 0)
                c1++;
            if (f2[i] > 0)
                c2++;
        }
        return c1 == c2;
    }
}