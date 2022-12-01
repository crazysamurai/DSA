// Intuition

// The answer List requires a list of players with 0 losses and a list of players with exactly 1 loss. If we manage to separate all the players that have lost a match we'll be left with only those who haven't i.e. list of winners and then we can easily store them in separate lists.
// Approach

//     We'll use a treemap and a treeset so that we won't have to sort the values later.
//     Find the Losers in the array: loop through the matches array and populate the treemap.
//     Now treemap contains all the players who have lost at least 1 match. Traverse through the map and find the players who have lost exactly 1 match and add them to the losers list.
//     Find the Winners in the array: loop through the matches array and check if the player exists in the previous map, if so then we'll skip that player and if not then we'll add that player to the set.
//     Again traverse through the set and add the keys to the winners list.
//     Add both the lists to the answer list and return.

// Code
import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeSet<Integer> map2 = new TreeSet<>();
        int n = matches.length;

        List<List<Integer>> ans = new ArrayList<>();// answer list
        List<Integer> listW = new ArrayList<>();// winners list
        List<Integer> listL = new ArrayList<>();// loosers list

        // finding the losers in the matches array
        for (int i = 0; i < n; i++) {
            if (map.containsKey(matches[i][1])) {
                map.put(matches[i][1], map.get(matches[i][1]) + 1);
            } else {
                map.put(matches[i][1], 1);
            }
        }
        // finding the player with exactly 1 loss
        for (int key : map.keySet()) {
            if (map.get(key) == 1)
                listL.add(key);
        }
        // separating the winners i.e. players with 0 losses
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(matches[i][0])) {
                map2.add(matches[i][0]);
            }
        }

        for (int key : map2) {
            listW.add(key);
        }

        ans.add(listW);
        ans.add(listL);
        return ans;
    }
}