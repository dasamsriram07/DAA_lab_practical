import java.util.*;
public class MatrixChainMultiplication {
    public static int matrixChain(int p[]) {
        int n = p.length - 1; // no of matrices
        int m[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;// for diagonal values
        }

        for (int length=2; length <= n; length++) {
            for (int i= 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) { // where to split
                    int cost = m[i][k]+
                               m[k + 1][j]+ 
                               p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                    }
                }
            }
        }

        return m[1][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        System.out.println("Enter dimensions:");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        System.out.println(
            "Minimum multiplications = " + matrixChain(p)
        );
    }
}