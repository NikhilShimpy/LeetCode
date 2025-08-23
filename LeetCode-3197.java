class Solution {
    public int minimumSum(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();

        int m = grid.length;
        int n = grid[0].length;

        int ans = getNext(0, 0, m - 1, n - 1, 3, grid, map);

        return ans;
    }

    private int getOne(int i1, int j1, int i2, int j2, int[][] grid, HashMap<String, Integer> map) {
        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxy = Integer.MIN_VALUE;

        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (grid[i][j] == 1) {
                    minx = Math.min(minx, i);
                    maxx = Math.max(maxx, i);
                    miny = Math.min(miny, j);
                    maxy = Math.max(maxy, j);
                }
            }
        }

        if (minx == Integer.MAX_VALUE) {
            return 0;
        }

        return (maxx - minx + 1) * (maxy - miny + 1);
    }

    private int getNext(int i1, int j1, int i2, int j2, int k, int[][] grid, HashMap<String, Integer> map) {
        String key = i1 + "," + j1 + "," + i2 + "," + j2 + "," + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int output = Integer.MAX_VALUE;

        if (k == 1) {
            output = getOne(i1, j1, i2, j2, grid, map);
        } else if (k == 2) {
            for (int i = i1; i < i2; i++) {
                output = Math.min(output, getNext(i1, j1, i, j2, 1, grid, map) + getNext(i + 1, j1, i2, j2, 1, grid, map));
            }
            for (int j = j1; j < j2; j++) {
                output = Math.min(output, getNext(i1, j1, i2, j, 1, grid, map) + getNext(i1, j + 1, i2, j2, 1, grid, map));
            }
        } else if (k == 3) {
            for (int i = i1; i < i2; i++) {
                output = Math.min(output, getNext(i1, j1, i, j2, 1, grid, map) + getNext(i + 1, j1, i2, j2, 2, grid, map));
                output = Math.min(output, getNext(i1, j1, i, j2, 2, grid, map) + getNext(i + 1, j1, i2, j2, 1, grid, map));
            }
            for (int j = j1; j < j2; j++) {
                output = Math.min(output, getNext(i1, j1, i2, j, 1, grid, map) + getNext(i1, j + 1, i2, j2, 2, grid, map));
                output = Math.min(output, getNext(i1, j1, i2, j, 2, grid, map) + getNext(i1, j + 1, i2, j2, 1, grid, map));
            }
        }

        map.put(key, output);
        return output;
    }
}
