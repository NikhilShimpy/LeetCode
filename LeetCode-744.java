class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        return bs(letters , target );
    }
    static char bs(char[] nums,char target ){
        int start =0;
        char ans = '$';
        int end = nums.length-1;
        
        while(start<=end){
            int mid = start + (end-start) / 2;
            if(nums[mid]<=target){
                start = mid+1;
            }else{
                end = mid-1;
                ans = nums[mid];
            }
        }
        return (ans == '$')?nums[0]:ans;
    }
}
