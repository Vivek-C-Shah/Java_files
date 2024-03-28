import java.util.*;

class Dijkstra {
    private int V;
    private List<int[]>[] adj; // Using an array of int arrays to store neighbors and weights

    public Dijkstra(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v, int w) {
        adj[u].add(new int[]{v, w}); // Store neighbor and weight as an int array
        adj[v].add(new int[]{u, w}); // Bidirectional edge
    }

    public void shortestPath(int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1])); // Compare by weight
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{0, src}); // Store distance and vertex as an int array
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1]; // Extract vertex
            for (int[] neighbor : adj[u]) {
                int v = neighbor[0]; // Extract neighbor
                int weight = neighbor[1]; // Extract weight
                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        System.out.print("Node " + src + ": ");
        for (int i = 0; i < V; ++i) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        Dijkstra g = new Dijkstra(V);
        g.addEdge(1, 0, 10);
        g.addEdge(1, 2, 50);
        g.addEdge(2, 4, 10);
        g.addEdge(0, 4, 100);
        g.addEdge(0, 3, 30);
        g.addEdge(2, 3, 20);
        g.addEdge(4, 3, 60);
        g.addEdge(0, 3, 30);

        for (int i = 0; i < V; ++i) {
            g.shortestPath(i);
        }
    }
}