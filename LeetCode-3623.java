class Solution {
      static final int M = (int)1e9 + 7;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int[] point : points) {
            int y = point[1];
            mp.put(y, mp.getOrDefault(y, 0) + 1);
        }

        long res = 0;
        long phl = 0;

        for (int count : mp.values()) {

            long hl = (long) count * (count - 1) / 2;  

            res = (res + hl * phl) % M;

            phl += hl;
        }

        return (int)(res % M);
    }
}
