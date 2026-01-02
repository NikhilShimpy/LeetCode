class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean arr[] = new boolean[n + 1]; 
        List<Integer> res = new ArrayList<>();

        for (int i : nums) {
            arr[i] = true;
        }

        for (int j = 1; j <= n; j++) {
            if (!arr[j]) {
                res.add(j);
            }
        }
        
        return res;
    }
}
