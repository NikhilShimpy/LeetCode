class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
         int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int s = Math.max(j - k, 0);
                int e = Math.min(j + k, n - 1);

                if (!res.isEmpty() && res.get(res.size() - 1) >= s) {
                    s = res.get(res.size() - 1) + 1;
                }

                for (int i = s; i <= e; i++) {
                    res.add(i);
                }
            }
        }

        return res;
    }
}
