import java.util.*;
public class Day22_AquaNet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0; i<V; i++) adj.add(new ArrayList<>());
            for(int i=0; i<E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            int[] visited = new int[V];
            Arrays.fill(visited, -1);
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<V; i++) {
                int hasWater = sc.nextInt();
                if (hasWater == 1) {
                    visited[i] = 0;
                    q.offer(i);
                }
            }
            int maxTime = 0;
            while(!q.isEmpty()) {
                int u = q.poll();
                maxTime = Math.max(maxTime, visited[u]);
                for(int v : adj.get(u)) {
                    if(visited[v] == -1) {
                        visited[v] = visited[u] + 1;
                        q.offer(v);
                    }
                }
            }
            for(int t : visited) {
                if (t == -1) {
                    System.out.println("-1");
                    return;
                }
            }
            System.out.println(maxTime);
        }
        sc.close();
    }
}