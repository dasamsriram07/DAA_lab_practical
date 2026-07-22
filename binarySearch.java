public class binarySearch {

    public static int bs(int arr[], int key) {
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
        int arr[] = {10, 20, 30, 40, 50};
        int key = 40;

        int res = bs(arr, key);
        System.out.println("Index = " + res);
    }
}