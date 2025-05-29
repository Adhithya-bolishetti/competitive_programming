import java.io.*;
import java.util.*;

public class Solution {

    public static void shortestPath(int[][] graph, int n, int start, int end) {
        int[] visited = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1); // To reconstruct path

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == end) break;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1 && visited[v] == 0) {
                    visited[v] = 1;
                    parent[v] = u;  // Store the path
                    q.offer(v);
                }
            }
        }

        // If end wasn't reached
        if (visited[end] == 0) {
            System.out.println("-1");
            return;
        }

        // Reconstruct path from end to start
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path); // Reverse to get path from start to end

        // Print the path
        for (int node : path) {
            System.out.print(node + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        shortestPath(graph, n, start, end);
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2)