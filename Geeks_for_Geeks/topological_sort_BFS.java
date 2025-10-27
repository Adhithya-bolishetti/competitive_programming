class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        int[] indeg = new int[V];
        for(int i=0;i<V;i++) {
            for(int j : adj.get(i)) {
                indeg[j]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++) {
            if(indeg[i] == 0) {
                q.offer(i);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            
            for(int it : adj.get(node)) {
                indeg[it]--;
                if(indeg[it] == 0) {
                    q.offer(it);
                }
            }
        }
        
        return res;
    }
}