import java.util.*;
public class Day29_MinWeightCycle {
    static class Edge {
        int to, weight;
        Edge(int t, int w) { to = t; weight = w; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String line = sc.nextLine();
            int V = Integer.parseInt(line.split("=")[1].trim());
            List<List<Edge>> adj = new ArrayList<>();
            for(int i=0; i<V; i++) adj.add(new ArrayList<>());
            sc.useDelimiter("[^0-9]+");
            while(sc.hasNextInt()) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                adj.get(u).add(new Edge(v, w));
                adj.get(v).add(new Edge(u, w));
            }
            int minCycle = Integer.MAX_VALUE;
            for (int i = 0; i < V; i++) {
                PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
                int[] dist = new int[V];
                Arrays.fill(dist, -1);
                int[] parent = new int[V];
                Arrays.fill(parent, -1);
                dist[i] = 0;
                pq.offer(new int[]{0, i});
                while(!pq.isEmpty()) {
                    int[] curr = pq.poll();
                    int d = curr[0];
                    int u = curr[1];
                    if (d > dist[u] && dist[u] != -1) continue;
                    for(Edge e : adj.get(u)) {
                        if (e.to == parent[u]) continue;
                        if (dist[e.to] != -1) {
                            minCycle = Math.min(minCycle, d + e.weight + dist[e.to]);
                        } else {
                            dist[e.to] = d + e.weight;
                            parent[e.to] = u;
                            pq.offer(new int[]{dist[e.to], e.to});
                        }
                    }
                }
            }
            System.out.println("Weight of Minimum Cycle: " + minCycle);
        } catch(Exception e) {}
        sc.close();
    }
}