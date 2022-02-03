import java.util.Collections;

public class subsetsum {
    ArrayList<Integer> SubsetSums(int [] arr){
        ArrayList<Integer> list = new ArrayList<>();
        fun(0, arr, 0, list);
        Collections.sort(list);
        return list;
    }

    void fun(int idx, int [] arr, int sum, ArrayList<Integer> list){
        if(idx==arr.length){
            list.add(sum);
            return;
        }
        fun(idx+1, arr, sum+arr[i], list);//pick the element
        fun(idx+1, arr, sum, list);//do not pick the element
    }

}