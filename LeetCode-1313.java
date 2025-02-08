class Solution {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int arrsize =0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i += 2){
            int f = nums[i];
            int v = nums[i+1];
            for (int j = 0; j < f; j++) {
                list.add(v);
            }
        }
        int[] resArray = new int[list.size()]; 
        Arrays.setAll(resArray, list::get); 
        return resArray; 
    }
}
