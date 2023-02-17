class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        fun(0, s, ans, ls);
        return ans;
    }
    
    public void fun(int idx, String s, List<List<String>> ans, List<String> ls){
        if(idx==s.length()){
            ans.add(new ArrayList<>(ls));
            return;
        }
        
        for(int i = idx; i<s.length(); i++){
            String ss = s.substring(idx, i+1);
            if(isPalindrome(ss)){
                ls.add(ss);
                fun(i+1, s, ans, ls);
                ls.remove(ls.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String ss){
        int left = 0;
        int right = ss.length()-1;
        while(left<=right){
            if(ss.charAt(left)!=ss.charAt(right)){
                return false;
                }
            left++;
            right--;
        }
        return true;
    }
}
