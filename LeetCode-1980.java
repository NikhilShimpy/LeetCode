class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].charAt(i) == '0') {
                res.append('1');
            } else {
                res.append('0');
            }
        }
        return res.toString();
    }
}
