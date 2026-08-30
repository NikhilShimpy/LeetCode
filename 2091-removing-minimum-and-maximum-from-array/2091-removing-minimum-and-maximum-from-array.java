class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minidx = 0;
        int maxidx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minidx]) {
                minidx = i;
            }

            if (nums[i] > nums[maxidx]) {
                maxidx = i;
            }
        }

        int left = Math.min(minidx, maxidx);
        int right = Math.max(minidx, maxidx);

        // remove : front se
        int bothfront = right + 1;

        // remove :  back
        int bothback = n - left;

        // remove kiya 1 front se 1 back se 
        int onefrontoneback = (left + 1) + (n - right);

        return Math.min(bothfront,
                Math.min(bothback, onefrontoneback));
    }
}

