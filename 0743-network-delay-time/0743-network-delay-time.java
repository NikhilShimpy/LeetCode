class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.get(u).add(new int[]{v, wt});
        }
        
        // Distance array
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[k] = 0;
        
        // Min Heap
        // {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        
        pq.offer(new int[]{0, k});
        
        while (!pq.isEmpty()) {
            
            int[] curr = pq.poll();
            
            int d = curr[0];
            int node = curr[1];
            
            // Ignore outdated entry
            if (d > dist[node]) {
                continue;
            }
            
            // Explore neighbours
            for (int[] neighbour : adj.get(node)) {
                
                int nextNode = neighbour[0];
                int weight = neighbour[1];
                
                int newDist = d + weight;
                
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    
                    pq.offer(new int[]{newDist, nextNode});
                }
            }
        }
        
        int res = 0;
        for(int i=1;i<=n;i++){
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res,dist[i]);
        }
        return res;
    }
}