class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int s = 0;
        int e = n-1;

        while(s<=e){
            int mid = s+(e-s) /2;

            if(target == arr[mid]) return mid;

            if(arr[s] <= arr[mid]){
                if(arr[s] <= target && target < arr[mid]){
                    e = mid-1;
                }else s= mid+1;

            }else{
                if(target > arr[mid] && target <= arr[e]){
                    s = mid+1;
                }else e = mid-1;

            }
        }
        return -1;
    }
}
