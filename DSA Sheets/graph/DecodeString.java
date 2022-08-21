//stack solution
class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch!=']'){
                st.push(ch);
            }else{
                StringBuilder ss = new StringBuilder();
                while(st.peek() != '['){
                    ss.insert(0,st.pop());
                }
                st.pop();
                
                StringBuilder num = new StringBuilder();
                while((!st.isEmpty()) && Character.isDigit(st.peek())){
                    num.insert(0,st.pop());
                }
                int k = Integer.valueOf(num.toString());
                
                String str = ss.toString();
                while(k>0){
                    for(int j = 0; j<str.length(); j++){
                        st.push(str.charAt(j));
                    }
                    k--;
                }
                
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) ans.insert(0,st.pop());
        return ans.toString();
    }
}

//graph solution

//The idea is: for the string in [ ] pair, we can recurse it as the source string. The codes go into the lower level at '[', and back to parent at ']'.
// The int pos is a globle parameter to indicate the current index of char in the String s.

private int pos = 0;
public String decodeString(String s) {
    int n = s.length(), repeat = 0;
    StringBuilder buf = new StringBuilder();
    while (pos < n) {
        char c = s.charAt(pos);
        if (c >= 'a' && c <= 'z') {
            buf.append(c);
        } else if (c >= '0' && c <= '9') {
            repeat = repeat * 10 + (c - '0');
        } else if (c == '[') {
            pos++;  // skip the char '['
            String str = decodeString(s);  // pos is diff for each call
            for (int i = 0; i < repeat; i++)
                   buf.append(str);
            repeat = 0;  // reset the value for the next input
        } else if (c == ']')
            break;
        pos++;
    }
    return buf.toString();
}