class Solution {
    public int myAtoi(String s) {
        int num = 0;
        Boolean negative = false;
        int i = 0;
        
        //handle spaces
        while(i<s.length() && s.charAt(i) == ' ') i++;
        
        //handle signs
        if(i<s.length() && s.charAt(i) == '-'){
            negative = true;
            i++;
        }else if(i<s.length() && s.charAt(i) == '+'){
            i++;
        }
        
        //number
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            char ch = s.charAt(i);
            int tempNum = ch-'0';
            
            if((Integer.MAX_VALUE - tempNum)/10 < num){
                //num = num * 10 + (tempNum)
                //(num-tempNum)/10 = num
                if(negative){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
            
            num = num * 10 + tempNum;
            i++;
        }
      
        if(num == 0) return 0;
        
        if(negative){
            return -num;
        }else return num;
        
    }
}