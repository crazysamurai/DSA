class Solution {
    public String intToRoman(int num) {
        String [] M = {"", "M", "MM", "MMM"}; //0, 1000, 2000, 3000 only upto 3k because Constraints: 1 <= num <= 3999
        String [] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; //0, 100, 200, 300, 400, 500, 600, 700, 800, 900
        String [] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; //0, 10, 20, 30, 40, 50, 60, 70, 80, 90
        String [] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; //0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        
        String res = M[num/1000]+C[(num%1000)/100]+X[(num%100)/10]+I[num%10];
        return res;
    }
}


// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
