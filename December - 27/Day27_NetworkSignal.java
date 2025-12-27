import java.util.*;
public class Day27_NetworkSignal {
    static class Edge {
        int to, weight;
        Edge(int t, int w) { to = t; weight = w; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            List<List<Edge>> adj = new ArrayList<>();
            for(int i=0; i<N; i++) adj.add(new ArrayList<>());
            for(int i=0; i<M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                adj.get(u).add(new Edge(v, w));
            }
            int S = sc.nextInt();
            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[S] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
            pq.offer(new int[]{S, 0});
            while(!pq.isEmpty()) {
                int[] curr = pq.poll();
                int u = curr[0];
                int d = curr[1];
                if (d > dist[u]) continue;
                for(Edge e : adj.get(u)) {
                    if (dist[u] + e.weight < dist[e.to]) {
                        dist[e.to] = dist[u] + e.weight;
                        pq.offer(new int[]{e.to, dist[e.to]});
                    }
                }
            }
            int maxDist = 0;
            for(int d : dist) {
                if (d == Integer.MAX_VALUE) {
                    System.out.println("-1");
                    return;
                }
                maxDist = Math.max(maxDist, d);
            }
            System.out.println(maxDist);
        }
        sc.close();
    }
}