//lc: https://leetcode.com/contest/biweekly-contest-95/problems/find-xor-beauty-of-array/

// You are given a 0-indexed integer array nums.

// The effective value of three indices i, j, and k is defined as ((nums[i] | nums[j]) & nums[k]).

// The xor-beauty of the array is the XORing of the effective values of all the possible triplets of indices (i, j, k) where 0 <= i, j, k < n.

// Return the xor-beauty of nums.

// Note that:

//     val1 | val2 is bitwise OR of val1 and val2.
//     val1 & val2 is bitwise AND of val1 and val2.

//  

// Example 1:

// Input: nums = [1,4]
// Output: 5
// Explanation: 
// The triplets and their corresponding effective values are listed below:
// - (0,0,0) with effective value ((1 | 1) & 1) = 1
// - (0,0,1) with effective value ((1 | 1) & 4) = 0
// - (0,1,0) with effective value ((1 | 4) & 1) = 1
// - (0,1,1) with effective value ((1 | 4) & 4) = 4
// - (1,0,0) with effective value ((4 | 1) & 1) = 1
// - (1,0,1) with effective value ((4 | 1) & 4) = 4
// - (1,1,0) with effective value ((4 | 4) & 1) = 0
// - (1,1,1) with effective value ((4 | 4) & 4) = 4 
// Xor-beauty of array will be bitwise XOR of all beauties = 1 ^ 0 ^ 1 ^ 4 ^ 1 ^ 4 ^ 0 ^ 4 = 5.

// Example 2:

// Input: nums = [15,45,20,2,34,35,5,44,32,30]
// Output: 34
// Explanation: The xor-beauty of the given array is 34.


class Solution {
    public int xorBeauty(int[] nums) {
        int res = 0;
        for (int val : nums)
            res ^= val;
        return res;
    }
}

//  In provided example 1 we can see a pattern forming, XOR of all beauties = 1 ^ 0 ^ 1 ^ 4 ^ 1 ^ 4 ^ 0 ^ 4 = 5.
//  1 appears 3x
//  4 appears 3x
//  0 appears 2x

//  XOR has a property that XOR of the same value is 0. This is because all the bits in the operands are the same, so the XOR operation will return a 0 for every bit.

//  so 1^1^1 = 0^1 = 1
//     4^4^4 = 0^4 = 4
//     =>1^4 = 5
// we are left with 1 and 4 which are also the values present in the array itself.

// same thing will happen for the testcase 2 and we'll be left with just the values in the array.
// So the simple solution would be to just XOR the values in the array.

// The problem is very cleverly named as well. wp leetcode.