package Practical1;
import java.util.Scanner;

public class selectionSort {
    public static void selection_sort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        selection_sort(arr);
        printArr(arr);

    }
}
// Time complexities
// best O(n^2)
// avg O(n^2)
// worst O(n^2)
// here in firstly the loop of j will be checking all the elements till it is completing