 private boolean reachable(int[][] grid, int i, int j, int mid) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] > mid)
            return false;

        visited[i][j] = true;

        if (i == n - 1 && j == n - 1)
            return true;

        for (int[] dir : dir) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if (reachable(grid, new_i, new_j, mid))
                return true;
        }

        return false;
    }
