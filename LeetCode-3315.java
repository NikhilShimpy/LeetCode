class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            if (num == 2) {
                result[i] = -1;
                continue;
            }

            boolean found = false;

            for (int j = 1; j < 32; j++) {
                // if jth bit is set, skip
                if ((num & (1 << j)) != 0) {
                    continue;
                }

                // found an unset bit at position j
                // flip (j-1)th bit
                result[i] = num ^ (1 << (j - 1));
                found = true;
                break;
            }

            if (!found) {
                result[i] = -1;
            }
        }

        return result;
    }
}
