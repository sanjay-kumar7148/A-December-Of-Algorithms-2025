import java.util.Scanner;
public class Day5_IslandCounter {
    public static void dfs(int[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) return;
        grid[r][c] = 0; 
        dfs(grid, r + 1, c, rows, cols);
        dfs(grid, r - 1, c, rows, cols);
        dfs(grid, r, c + 1, rows, cols);
        dfs(grid, r, c - 1, rows, cols);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            int[][] grid = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int count = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (grid[i][j] == 1) {
                        count++;
                        dfs(grid, i, j, R, C);
                    }
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}