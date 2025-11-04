class Solution {
    private int findTopXSum(Map<Integer, Integer> map, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int val = entry.getKey();
            pq.offer(new int[]{freq, val});

            if (pq.size() > x) {
                pq.poll();
            }
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            sum += pair[0] * pair[1];
        }

        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (j - i + 1 == k) {
                res.add(findTopXSum(map, x));

                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }

            j++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
