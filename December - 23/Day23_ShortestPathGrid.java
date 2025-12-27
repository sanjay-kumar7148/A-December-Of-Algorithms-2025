import java.util.*;
public class Day23_ShortestPathGrid {
    static class Node {
        int r, c, dist;
        Node(int r, int c, int d) { 
            this.r = r; 
            this.c = c; 
            this.dist = d; 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];          
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++) 
                grid[i][j] = sc.nextInt();
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            System.out.println("-1");
            return;
        }
        boolean[][] visited = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0)); 
        visited[0][0] = true;
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.r == m - 1 && curr.c == n - 1) {
                System.out.println(curr.dist); 
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && 
                    grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, curr.dist + 1));
                }
            }
        }
        System.out.println("-1");
        sc.close();
    }
}