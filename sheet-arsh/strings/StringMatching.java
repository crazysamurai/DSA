//brute force
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null) return 0;
        
        if(haystack.length()==1 && needle.length()==1){
            if(haystack.equals(needle))return 0;
            else return -1;
        }
        
        for(int i = 0; i<haystack.length(); i++){
            for(int j = i+(needle.length()); j<haystack.length()+1; j++){
                String ss = haystack.substring(i,j);
                if(ss.equals(needle)) return i;
            }
        }
        return -1;
    }
}

//KMP algo
