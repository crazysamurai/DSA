class Solution {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]", "");
        s=s.toLowerCase();
        int size = s.length();
        System.out.println(s);
        return recursion(s, size, 0);
    } 
    
    public boolean recursion(String s, int size, int i){
        if(i>=size/2) return true;
        if(s.charAt(i)!=s.charAt(size-i-1)){return false; }
        return recursion(s,size,i+1);
    }
}