class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> prev = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int num : arr) {
            for (int x : prev) {
                curr.add(x | num);
                res.add(x | num);
            }

            curr.add(num);
            res.add(num);

            prev = curr;
            curr = new HashSet<>();
        }

        return res.size();
    }
}
