import java.util.*;
public class Day25_MazeKeys {
    static class State {
        int r, c, keys, dist;
        State(int r, int c, int k, int d) {
            this.r = r; this.c = c; this.keys = k; this.dist = d;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            char[][] grid = new char[R][C];
            int startR = 0, startC = 0;
            for(int i=0; i<R; i++) {
                String row = sc.next();
                for(int j=0; j<C; j++) {
                    grid[i][j] = row.charAt(j);
                    if (grid[i][j] == 'S') {
                        startR = i; startC = j;
                    }
                }
            }
            Queue<State> q = new LinkedList<>();
            q.offer(new State(startR, startC, 0, 0));
            boolean[][][] visited = new boolean[R][C][1024];
            visited[startR][startC][0] = true;
            int[] dr = {0, 0, 1, -1};
            int[] dc = {1, -1, 0, 0};
            while(!q.isEmpty()) {
                State curr = q.poll();
                if (grid[curr.r][curr.c] == 'T') {
                    System.out.println(curr.dist);
                    return;
                }
                for(int i=0; i<4; i++) {
                    int nr = curr.r + dr[i];
                    int nc = curr.c + dc[i];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] != '#') {
                        char cell = grid[nr][nc];
                        int newKeys = curr.keys;
                        if (cell >= 'A' && cell <= 'J') {
                            if ((curr.keys & (1 << (cell - 'A'))) == 0) continue; 
                        } else if (cell >= 'a' && cell <= 'j') {
                            newKeys |= (1 << (cell - 'a'));
                        }
                        if (!visited[nr][nc][newKeys]) {
                            visited[nr][nc][newKeys] = true;
                            q.offer(new State(nr, nc, newKeys, curr.dist + 1));
                        }
                    }
                }
            }
            System.out.println("-1");
        }
        sc.close();
    }
}