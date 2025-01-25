//Solution for leetcode problem 2679. Sum in a Matrix

class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m= nums[0].length;
        int score =0;

        if(n ==1 && m ==1) return nums[0][0];

        for(int []row:nums)
        {
                Arrays.sort(row);
        }
        
        for(int i=0;i<m;i++){
            int max=nums[0][i];
            for(int j=1;j<n;j++){
                if(max<nums[j][i]) max = nums[j][i];
            }
            score += max;
        }
        return score;
    }
}
