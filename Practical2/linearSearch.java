package Practical2;
import java.util.*;
public class linearSearch{
    public static int ls(int arr[], int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("enter the elements of array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("enter key value");
        int key = sc.nextInt();
        int res = ls(arr,key);
        System.out.println("element is found at" + res);
    }
}