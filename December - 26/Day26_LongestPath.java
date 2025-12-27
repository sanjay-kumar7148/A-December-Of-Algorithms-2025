import java.util.Scanner;
public class Day26_LongestPath {
    static int[][] grid;
    static int[][] memo;
    static int R, C;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static int dfs(int r, int c) {
        if (memo[r][c] != 0) return memo[r][c];
        int maxLen = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] > grid[r][c]) {
                maxLen = Math.max(maxLen, 1 + dfs(nr, nc));
            }
        }
        memo[r][c] = maxLen;
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            R = sc.nextInt();
            C = sc.nextInt();
            grid = new int[R][C];
            memo = new int[R][C];
            for(int i=0; i<R; i++)
                for(int j=0; j<C; j++)
                    grid[i][j] = sc.nextInt();
            int ans = 0;
            for(int i=0; i<R; i++)
                for(int j=0; j<C; j++)
                    ans = Math.max(ans, dfs(i, j));
            System.out.println(ans);
        }
        sc.close();
    }
}