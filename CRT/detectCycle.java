import java.io.*;
import java.util.*;

public class Solution {
    public static boolean detect(int[][] graph, int n, int[] visited, int[] parent, Queue<Integer> q) {
        if(q.isEmpty()) return false;
        int u = q.poll();
        for(int v=0;v<n;v++) {
            if(graph[u][v] == 1) {
                if(visited[v] == 0) {
                    q.offer(v);
                    visited[v] = 1;
                    parent[v] = u;
                }
                else if(parent[u] != v) {
                    return true;
                }
            }
        }
        return detect(graph, n, visited, parent, q);
    }
    public static boolean detectCycle(int[][] graph, int n) {
        int[] visited = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent,-1);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(visited[i] == 0) {
                q.offer(i);
                visited[i] = 1;
                if(detect(graph, n, visited, parent, q)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        if(detectCycle(graph,n)) System.out.print("True");
        else System.out.print("False");
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2)