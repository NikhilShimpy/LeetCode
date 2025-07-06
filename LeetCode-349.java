class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }

        Set<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) {
          
            if (set1.contains(n)) {
                set2.add(n);
            }
        }

        int[] res = new int[set2.size()];
        int index = 0;
        for (Integer n : set2) {
            res[index++] = n;
        }

        return res;
    }
}
