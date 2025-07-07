class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        

        int n1 = nums1.length;
        int n2 = nums2.length;
        int p1=0 ,p2=0;

        while(p1 < n1 && p2 <n2){
            if(nums1[p1] == nums2[p2] ){
                return nums1[p1];
            }else if(nums1[p1] < nums2[p2] ){
                p1++;
            }else {
                p2++;
            }
        }
        return -1;
    }
}
