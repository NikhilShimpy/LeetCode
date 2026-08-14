
//bfs
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        //create adj list
        for(int i=1;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        //build graph
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int count= 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(i,adj,visited);
                count++;
            }
        }
    return count;
    }
    public void bfs(int node,ArrayList<ArrayList<Integer>> adj , boolean[] visited ){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]=true;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int next : adj.get(curr)){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}

//DFS
// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         //create adj list
//         for(int i=1;i<=n;i++){
//             adj.add(new ArrayList<>());
//         }
//         //build graph
//         for(int i=0;i<n;i++){
//             for(int j =0;j<n;j++){
//                 if(isConnected[i][j] == 1){
//                     adj.get(i).add(j);
//                     adj.get(j).add(i);
//                 }
//             }
//         }
//         boolean[] visited = new boolean[n];
//         int count = 0;

//         for(int i=0;i<n;i++){
//             if(!visited[i]){
//                 dfs(i,adj,visited);
//                 count++;
//             }
//         }
//         return count;
//     }
//     public void dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited){
//         visited[node] = true;
//         for(int next : adj.get(node)){
//             if(!visited[next]){
//                 dfs(next,adj,visited);
//             }
//         }
//     }
// }