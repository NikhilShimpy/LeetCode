class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Min Heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        // 3. Put every (number, frequency) into heap
        for (int key : map.keySet()) {

            pq.offer(new int[]{key, map.get(key)});

            // Keep only k most frequent elements
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // 4. Extract answer
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}