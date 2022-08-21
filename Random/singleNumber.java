// APPROACH: We take the XOR of all the elements of the array with each other.

// INTUITION: XOR is associative property in decimals.
// for ex: array is [2,3,4,3,4]
// So, 2^3^4^3^4 = 2^(3^3)^(4^4)
// and We all know that (x^x)=0
// ** So, if after taking the XOR we get a non-zero value, it means there is a non-repeating element. **

class Solution {
        public int singleNumber(int[] A) {
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            num = num ^ A[i];
        }
        return num;
    }
    
}