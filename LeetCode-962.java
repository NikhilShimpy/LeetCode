class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int maxr[] = new int[n+1];

        maxr[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--){
            maxr[i] = Math.max(nums[i],maxr[i+1]);
        }

        int res = 0; //ramp hai 
        int i=0,j=0;

        while(j<n){
            while(i<j && nums[i]>maxr[j]) i++;
            res = Math.max(j-i,res);
            j++;
        }
        return res;

    }
}

//monotonic stack 
// class Solution {
//     public int maxWidthRamp(int[] nums) {
//         int n = nums.length;
//         Deque<Integer> stack = new ArrayDeque<>();
        
//         for (int i = 0; i < n; i++) {
//             if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
//                 stack.push(i);
//             }
//         }

//         int max = 0;
//         for (int j = n - 1; j >= 0; j--) {
//             while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
//                 max = Math.max(max, j - stack.pop());
//             }
//         }
        
//         return max;
//     }
// }
