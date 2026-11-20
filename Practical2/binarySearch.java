package Practical2;
import java.util.*;
public class binarySearch {
    public static int bs(int arr[], int key) {
        // Arrays.sort(arr);
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
         int n = sc.nextInt();
       
        int arr[] = new int[n];
        System.out.println("enter the elements (which are sorted) of array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("enter key value");
        int k = sc.nextInt();
        System.out.println(bs(arr,k));
    }
}