class Solution {

    void dfs(int node, HashMap<Integer, ArrayList<Integer>> invoke, int[] vis) {
        vis[node] = 1;

        if (!invoke.containsKey(node))
            return;

        for (int it : invoke.get(node)) {
            if (vis[it] == 0) {
                dfs(it, invoke, vis);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer, ArrayList<Integer>> invoke = new HashMap<>();

        for (int[] it : invocations) {
            int u = it[0];
            int v = it[1];

            invoke.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
        }

        int[] vis = new int[n];
        dfs(k, invoke, vis);

        List<Integer> rem = new ArrayList<>();

        for (int[] it : invocations) {
            int u = it[0];
            int v = it[1];

            if (vis[u] == 0 && vis[v] == 1) {
                for (int i = 0; i < n; i++)
                    rem.add(i);
                return rem;
            }
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0)
                rem.add(i);
        }

        return rem;
    }
}