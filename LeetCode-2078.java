class Solution {
    public int maxDistance(int[] colors) {
        int j = colors.length;

        for (int i = 0; i < j; i++)
            if (colors[i] != colors[j - 1] || colors[j - 1 - i] != colors[0])
                return j - 1 - i;

        return 0;
    }
}
