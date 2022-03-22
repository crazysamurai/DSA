class Solution {
    public String simplifyPath(String s) {
        String [] arr = s.split("/");
        Stack<String> st = new Stack<>();
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i].equals("..")){
                if(!st.isEmpty()) st.pop();
            }else if(!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals("..")){
                st.push(arr[i]);
            }
        }
        
        if(st.isEmpty()) return "/"; //it handles the condition when the stack is empty which means we are currently at root folder

        String ans = "";
        while(!st.isEmpty()){
            ans = "/" + st.pop() + ans;
        }
        return ans;
    }
}