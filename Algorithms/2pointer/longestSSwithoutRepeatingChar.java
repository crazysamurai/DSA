class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = 0;
        while(right<s.length()){
            if(hm.containsKey(s.charAt(right))){
                left = Math.max(hm.get(s.charAt(right))+1, left);
            }
            hm.put(s.charAt(right),right);
            length = Math.max(length, right-left+1);
            right++;
        }
        return length;
    }
}