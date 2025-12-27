import java.util.*;
public class Day6_MagicSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n % 2 == 0) {
                System.out.println("Magic square is only possible for odd values of n.");
            } else {
                int magicConstant = n * (n * n + 1) / 2;
                System.out.println("Magic constant: " + magicConstant);  
                int[][] square = new int[n][n];
                int i = n / 2;
                int j = n - 1;
                for (int num = 1; num <= n * n; num++) {
                    square[i][j] = num;
                    int nextI = (i - 1 + n) % n;
                    int nextJ = (j + 1) % n;
                    if (square[nextI][nextJ] != 0) {
                        j = (j - 1 + n) % n; 
                    } else {
                        i = nextI;
                        j = nextJ;
                    }
                }
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        System.out.printf("%2d  ", square[r][c]);
                    }
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}