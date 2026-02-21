class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        
        int count = 2*k+1;

        if(n<count) return res;

        int i = k, left = 0, right = 2*k ;
        long sum = 0;
        for(int j = left;j<=right;j++) sum += nums[j];

        res[i] = (int) (sum /(count));
        i++;
        right++;

        while(right<n){
            sum = sum + nums[right] - nums[left];
            res[i] = (int) (sum /(count));
            i++;right++;left++;
        }
        return res;
    }
}
