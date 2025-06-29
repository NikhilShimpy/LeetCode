class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if (k == nums.length)
            return nums;

        int[] temp = Arrays.copyOf(nums, nums.length);

        Arrays.sort(temp); 
        int threshold = temp[temp.length - k];
        int countThreshold = 0;
        for (int i = temp.length - k; i < temp.length; i++) {
            if (temp[i] == threshold)
                countThreshold++;
        }

        int[] res = new int[k];
        int index = 0;

        for (int num : nums) {
            if (num > threshold) {
                res[index++] = num;
            } else if (num == threshold && countThreshold > 0) {
                res[index++] = num;
                countThreshold--;
            }
            if (index == k)
                break;
        }

        return res;
    }
}
