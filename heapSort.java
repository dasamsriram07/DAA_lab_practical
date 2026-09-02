import java.util.*;

public class heapSort{

    public static void heapify(int arr[], int i , int size ){ // for finding the max heap like swaping left or right child with root if they are not in corr pos
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i; //assume firstly root as max index

        if(left<size && arr[left] > arr[maxIdx]){
            maxIdx= left;
        }

        if(right<size && arr[right] >arr[maxIdx]){
            maxIdx = right;
        }
        if(maxIdx!=i){
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSORT(int arr[]){
         // step1 build maxHeap
         int n = arr.length;
         for(int i=n/2;i>=0;i--){ //n/2 beacuse leaf nodes no need to heapify
            heapify(arr,i,n); //O(n/2*logn)
         }

        //  step2 push largest at end

        for(int i = n-1;i>0;i--){
            // swap(largest - first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,0,i); //from top down approach 
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
       heapSORT(arr);

    //    print
    for(int i =0;i<arr.length;i++){
        System.out.print(arr[i]+ " ");
    }
    System.out.println();

    }
}