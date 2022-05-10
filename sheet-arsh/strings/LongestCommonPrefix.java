class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        
        if(strs.length == 0 || strs == null) return res;
        
        for(int i = 0; i<strs[0].length(); i++){
            for(int j = 0; j<strs.length; j++){
                if(i>=strs[j].length() || strs[0].charAt(i)!=strs[j].charAt(i)) return res;
            }
            res+=strs[0].charAt(i);
        }
        return res;
    }
}
//https://leetcode.com/problems/longest-common-prefix/submissions/