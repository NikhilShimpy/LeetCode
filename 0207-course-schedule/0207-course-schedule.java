class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        // Build graph
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            //(u=0,v=1), mtlb 0 ke pehle 1 krna hoga so v-->u
            adj.get(v).add(u);
            indegree[u]++;
        }
         Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        //BFS
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(int next : adj.get(node)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }
        return count == numCourses ? true : false;
    }
    
}