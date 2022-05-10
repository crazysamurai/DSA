//greedy+2ptr
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length-1;
        int boats = 0;
        Arrays.sort(people);
        while(i<j){
            if(people[i] + people[j]<=limit){
                i++;
                j--;
                boats++;
            }else{
                j--;
                boats++;
            }
        }
        if(i==j)boats++;
        return boats;
    }
}