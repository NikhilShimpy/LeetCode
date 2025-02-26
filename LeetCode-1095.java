/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
       int n = mountainArr.length();
       int s = 0;
       int e  = n-1;
       int mid = -1;
    
       while(s<=e){
        mid = s + (e-s)/2;
        int current  = mountainArr.get(mid);
        if(mid!=0 && mid != n-1 && current>mountainArr.get(mid-1) && current>mountainArr.get(mid+1)){
            if(current  ==  target) return mid;
            else break;
        }
        else if(mid!=n-1 && current<mountainArr.get(mid+1)) s = mid+1;
        else e = mid-1;

       } 

        s =0 ;
        e = mid-1;
        while(s<=e){
        int m = s + (e-s)/2;
        int cur  = mountainArr.get(m);
        if(cur == target ) return m;
        else if(target<cur) e = m-1;
        else s = m+1;

       } 

        s =mid+1 ;
        e = n-1;
        while(s<=e){
        int m = s + (e-s)/2;
        int cur  = mountainArr.get(m);
        if(cur == target ) return m;
        else if(target<cur) s = m+1;
        else e = m-1;
       } 
       return -1;
    }
}
