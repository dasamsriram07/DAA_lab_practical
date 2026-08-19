import java.util.Scanner;

public class mergeSort {

    public static void mergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[] , int si, int mid , int ei){
        int temp[] = new int [(ei-si+1)];
        int i = si; //for left iterator
        int j = mid+1;//for right iterator
        int k = 0;//for temp iterator
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){ 
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // for left over ele in left array
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        // for left over parts in right array
        while(j<=ei){
            temp[k++] = arr[j++];
        }

        for(k=0 ,i=si; k<temp.length;k++,i++){
            arr[i] = temp[k];
        }
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        // int arr[] = {56,12,56,46,35,785};
         Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("enter the elements of array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
// Time complexity
// best worst and avg are O(nlogn)
// as it becomes T(n) = 2T(n/2)+nk