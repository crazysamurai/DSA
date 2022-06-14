package sheet.arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0; int j = numbers.length-1;
        int ans [] = new int [2];
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else if(sum == target){
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }
        }
        return ans;
    }
}
// https://www.youtube.com/watch?v=cQ1Oz4ckceM
