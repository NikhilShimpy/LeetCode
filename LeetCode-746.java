class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return find(cost, cost.length,map);
    }

    int find(int[] arr, int n,HashMap<Integer, Integer> map) {
        if (n <= 1) return 0;
        
        if(map.containsKey(n)) return map.get(n);
        int res = Math.min(find(arr, n - 1,map) + arr[n - 1], find(arr, n - 2,map) + arr[n - 2]);
        map.put(n,res);
        return map.get(n);
    }
}
