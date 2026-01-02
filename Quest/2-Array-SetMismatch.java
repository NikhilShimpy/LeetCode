class Solution {
    public int[] findErrorNums(int[] nums) {
       int n = nums.length;
       boolean arr[] = new boolean[n+1];
     
       int[] res = new int[2];
       
       for(int i : nums){
        if(arr[i]){
            res[0] = i;
        }else{
            arr[i] = true;
        }
       }

       for(int j = 1;j<=n;j++){
        if(!arr[j]){
            res[1] = j;
            break;
        }
       }
    return res;
    }
}
