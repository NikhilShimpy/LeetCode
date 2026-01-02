class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int c[]=new int[n];
       
        for(int i=0;i<n;i++)
        {
             int count=0;
             for(int j=0;j<n;j++)
             {
                if(nums[j]<nums[i])
                count++;
            }
            c[i]=count;
        }
        return c;
    }
}
