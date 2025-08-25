class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
    
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i + j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }
        
        List<Integer> reslist = new ArrayList<>();
        boolean flip = true;
        
        for (int k = 0; k <= m + n - 2; k++) {
            List<Integer> diagonal = map.get(k);
            if (diagonal == null) continue;
            
            if (flip) {
                Collections.reverse(diagonal);
            }
            reslist.addAll(diagonal);
            
            flip = !flip;
        }
        
        int[] res = new int[reslist.size()];
        for (int i = 0; i < reslist.size(); i++) {
            res[i] = reslist.get(i);
        }
        
        return res;
    }
}
