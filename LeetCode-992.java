class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        int i = 0;
        int j = 0;
        int iex = 0; //i_bada
        
        int res = 0;
  
        while(j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            
            while(mp.size() > k) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if(mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
                iex = i;
            }
            
            while(mp.get(nums[i]) > 1) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                i++;
            }
            
            if(mp.size() == k) {
                res += i - iex + 1;
            }
            j++;
        }
        
        return res;
    }
}



// // 2 pass solution
// class Solution {
    
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
//     }

//     public int slidingWindow(int[] nums, int k) {
//         HashMap<Integer, Integer> mp = new HashMap<>();
        
//         int n = nums.length;
//         int i = 0; 
//         int j = 0;
        
//         int count = 0;
        
//         while(j < n) {
            
//             mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            
//             while(mp.size() > k) {
//                 //shirnk
//                 mp.put(nums[i], mp.get(nums[i]) - 1);
//                 if(mp.get(nums[i]) == 0) {
//                     mp.remove(nums[i]);
//                 }
//                 i++;
//             }
            
//             count += (j - i + 1); // subarr jo j pr end ho rhe
//             j++;
//         }
        
//         return count;
//     }
// }
