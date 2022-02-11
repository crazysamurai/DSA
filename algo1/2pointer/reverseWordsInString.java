class Solution {
    public String reverseWords(String s) {
        char [] str = s.toCharArray();
        for(int i = 0; i<str.length; i++){
            if(str[i]!=' '){
                int j = i;
                while(j+1<str.length && str[j+1]!=' '){ //loop j till the next space and then call the swap function
                    j++;
                }
                swap(i,j,str);
                i=j;
            }
        }
        String s2 = new String(str);
        return s2;
    }
    
    public void swap(int i, int j, char [] str){
        while(i<j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
}
