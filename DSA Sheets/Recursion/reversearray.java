import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i<n;i++){
            arr[i] = scn.nextInt();
        }
        displayArrReverse(arr, 0, n-1);
        for(int i = 0; i<n;i++){
            System.out.println(arr[i]);
        }
    }

    //two pointer approach
    public static void displayArrReverse(int[] arr, int i, int j) {
        if(i>=j)return;
        swap(arr, i, j);
        displayArrReverse(arr, i+1, j-1);
    }


    //single pointer approach
    // public static void main(String[] args) throws Exception {
    //     // write your code here
    //     Scanner scn = new Scanner(System.in);
    //     int n = scn.nextInt();
    //     int [] arr = new int [n];
    //     for(int i = 0; i<n;i++){
    //         arr[i] = scn.nextInt();
    //     }
    //     displayArrReverse(arr,0, n);
    //     for(int i = 0; i<n;i++){
    //         System.out.println(arr[i]);
    //     }
    // }

    // public static void displayArrReverse(int[] arr, int i, int n) {
    //     if(i>=n/2)return;
    //     swap(arr, i, n-i-1);
    //     displayArrReverse(arr, i+1, n);
    // }

    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}