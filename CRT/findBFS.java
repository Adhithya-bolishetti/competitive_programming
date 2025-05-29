import java.io.*;
import java.util.*;

public class Solution {
    public static void printBFS(int[][] graph, int n, int start) {
        int[] visited = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;
        while(!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u+" ");
            for(int j=0; j<n; j++) {
                if(visited[j] == 0 && graph[u][j] == 1) {
                    q.offer(j);
                    visited[j] = 1;
                }
            }
        }
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int start = sc.nextInt();
        printBFS(graph,n,start);
    }
}
// Time complexity : O(n^2)
// Space complexity : O(n^2)