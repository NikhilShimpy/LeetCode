class Solution {
    public boolean validMountainArray(int[] arr) {
       int index = 0 ;
       int n = arr.length;

       while(index<n-1){
        if(arr[index]<arr[index+1]) index++;
        else break;
       } 
       if(index == n-1 || index == 0) return false;
       while(index<n-1){
        if(arr[index]>arr[index+1]) index++;
        else break;
       } 
       return (index == n-1);
    }
}
