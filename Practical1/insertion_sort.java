import java.util.*;
public class insertion_sort {
    public static void insertion(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr =arr[i];
            int prev=i-1;
            // finding out the correct pos to insert
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            // insertion
            arr[prev+1]=curr;
        }
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[]){
        // int arr[]={5,4,1,3,2};
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("enter the elements of array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        insertion(arr);
        printArr(arr);
    }
}

// Time complexities
// best O(n)
// avg O(n^2)
// worst O(n^2)