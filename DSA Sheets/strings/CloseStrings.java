
//https://leetcode.com/problems/determine-if-two-strings-are-close/description/
import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int s1 = word1.length();
        int s2 = word2.length();

        if (s1 != s2)
            return false; // if the strings are of different lengths then the strings are not close

        // HashMaps to store characters along with their frequency in each string
        HashMap<Character, Integer> hm1 = new HashMap<>(); // for word1
        HashMap<Character, Integer> hm2 = new HashMap<>(); // for word2

        // populating the hashmaps
        for (int i = 0; i < s1; i++) {
            hm1.put(word1.charAt(i), hm1.getOrDefault(word1.charAt(i), 0) + 1);
            hm2.put(word2.charAt(i), hm2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        if (!hm1.keySet().equals(hm2.keySet()))
            return false;

        // if the size of both hashmaps is not the same, that would mean they have
        // different characters
        if (hm1.size() != hm2.size())
            return false;

        // Store the frequencies from each hashmap into these arraylists
        // We need to do this because of operation2 in the question. The frequencies of
        // the two different characters we want to transform must be same.
        List<Integer> ls1 = new ArrayList<>(hm1.values());
        List<Integer> ls2 = new ArrayList<>(hm2.values());

        // Sort the lists so that we can compare both of them in the next step
        Collections.sort(ls1);
        Collections.sort(ls2);

        return ls1.equals(ls2);

    }
}