import java.util.Scanner;

public class quickSort{
 public static void  quickSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        // last element
        int pIdx = partition(arr,si,ei);
        quickSort(arr, si, pIdx-1); //left part
        quickSort(arr, pIdx+1, ei);//right
    }
    public static int partition(int arr[], int si, int ei){
        int pivot =arr[ei];
        int i=si-1; // to make place for ele smaller than pivot

        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                // swap
                int temp =arr[j];
                arr[j]=arr[i];
                arr[i]=temp;

            }
        }
        i++;
        // swaping arr[i+1] and arr[ei]
        int temp =pivot;
         arr[ei]=arr[i]; //pivot =arr[i] wrong
        arr[i]=temp;
        return i;
    }
      public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
    public static void main(String[] args) {
        // int arr[] = {3,2,5,6,9,8};
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("enter the elements of array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}