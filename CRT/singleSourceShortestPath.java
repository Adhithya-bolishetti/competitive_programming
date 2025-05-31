import java.util.*;

class Pair implements Comparable<Pair> {
    int node;
    int cost;
    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    public int compareTo(Pair other) {
        return this.cost - other.cost; // Min-heap based on cost
    }
}

class Main {
    public static int[] singleSourceShortestPath(List<List<Pair>> adj, int n, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            if (visited[u]) continue;
            visited[u] = true;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.cost;

                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();      // Number of nodes
        int m = sc.nextInt();      // Number of edges

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Pair(v, w));
            // For undirected graph, also add: adj.get(v).add(new Pair(u, w));
        }

        int start = sc.nextInt();
        int[] dist = singleSourceShortestPath(adj, n, start);

        for (int i = 0; i < n; i++) {
            System.out.println("Path cost from " + start + " to " + i + " is " + dist[i]);
        }
    }
}
// Time complexity : O((V + E) log V)
// Space complexity : O(V + E)