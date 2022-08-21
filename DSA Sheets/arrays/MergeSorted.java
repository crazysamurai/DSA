package sheet.arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        
        while(i>=0 && j>=0){
            if(nums1[i] < nums2[j]){
                nums1[k] = nums2[j];
                j--;
            }else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
        //if there are still some elements left int the second array we'll just add them straight up because they are already sorted
        while(j>=0){
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}
//https://www.youtube.com/watch?v=P1Ic85RarKY
//https://www.youtube.com/watch?v=hVl2b3bLzBw&t=56s