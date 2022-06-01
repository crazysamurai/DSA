class Solution {
    String removeDuplicates(String str) {
        Map<Character, Integer> hm = new HashMap<>();
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (!hm.containsKey(str.charAt(i))) {
                hm.put(str.charAt(i), 1);
                res += str.charAt(i);
            } else {
                hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
            }
        }
        System.out.println(hm);
        return res;
    }
}
// https://practice.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1#