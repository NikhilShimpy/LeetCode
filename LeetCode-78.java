class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>()); 

        for (int num : nums) {
            int size = res.size(); 
            for (int i = 0; i < size; i++) {
                List<Integer> copy = new ArrayList<>(res.get(i));
                copy.add(num);
                res.add(copy);
            }
        }
        return res;
    }
}
