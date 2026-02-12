class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        //nothi
        HashMap<Integer, HashMap<Integer, Integer>> seg = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> ps = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }
                
                int g = gcd(dx, Math.abs(dy));
                int sx = dx / g;
                int sy = dy / g;
                
                int lp = sx * points[i][1] - sy * points[i][0];
                
                int kn = (sx << 12) | (sy + 2000);
                int kfull = (dx << 12) | (dy + 2000);
                
                seg.computeIfAbsent(kn, k -> new HashMap<>())
                       .merge(lp, 1, Integer::sum);
                ps.computeIfAbsent(kfull, k -> new HashMap<>())
                                .merge(lp, 1, Integer::sum);
            }
        }
        
        return calculate(seg) - calculate(ps) / 2;
    }
    
    private int calculate(HashMap<Integer, HashMap<Integer, Integer>> map) {
        long res = 0;
        
        for (HashMap<Integer, Integer> inner_map : map.values()) {
            long total = 0;
            
            for (int count : inner_map.values()) {
                total += count;
            }
            
            for (int count : inner_map.values()) {
                total -= count;
                res += (long) count * total;
            }
        }
        
        return (int) res;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
}
