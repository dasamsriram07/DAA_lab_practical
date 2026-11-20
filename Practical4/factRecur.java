package Practical4;
import java.util.Scanner;

public class factRecur {
    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number which you want to know what is it's factorial:");
        int n = sc.nextInt();
        System.out.println("The factorial of " + n + " is " + fact(n));
        sc.close();
    }
}
// Time complexity is O(n)
// T(n) = T(n-1) + O(1)
// Space complexity: O(n) due to recursion stack