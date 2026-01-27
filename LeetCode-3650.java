class Solution {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int minCost(int n, int[][] edges) {

        // Adjacency list: node -> {neighbor, weight}
        Map<Integer, List<Pair>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, wt));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, 2 * wt)); // reversed edge
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Min-heap based on distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Pair(0, 0)); // node, distance

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int d = cur.dist;

            // Skip stale entries
            if (d > dist[node]) continue;

            if (node == n - 1) return d;

            if (!adj.containsKey(node)) continue;

            for (Pair nei : adj.get(node)) {
                int nextNode = nei.node;
                int weight = nei.dist;

                if (d + weight < dist[nextNode]) {
                    dist[nextNode] = d + weight;
                    pq.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return -1;
    }
}
