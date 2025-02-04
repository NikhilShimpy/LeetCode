class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;

        int ls[] = new int[n]; //leftSum
        int rs[] = new int[n]; //rightSum
        

        int l = 0 , r = 0;int j = n-1;

        for(int i=0;i<n;i++){
            ls[i] = l;
            l = l+nums[i];
            
            rs[j]=r;
            r= r+nums[j];
            j--;
        }
        for(int i=0;i<n;i++){
            ls[i] =  Math.abs(ls[i]-rs[i]);
        }
        
        return ls;
    }
}
