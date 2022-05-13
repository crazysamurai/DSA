// O(n) space because strings are immutable in java
class Solution {
    public String reverseWords(String s) {
        String arr [] = s.split(" ");
        String res = "";
        for(int i = arr.length-1; i>=0; i--){
            if(!arr[i].equals("")){
                res += arr[i] + " ";
            }
        }
        return res.trim();
    }
}
