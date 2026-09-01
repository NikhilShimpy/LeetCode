class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    static class State {
        int row;
        int col;
        int energyleft;
        int collectedmask;

        State(int row, int col, int energyleft, int collectedmask) {
            this.row = row;
            this.col = col;
            this.energyleft = energyleft;
            this.collectedmask = collectedmask;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int maxEnergy = energy;

        int[][] litterbit = new int[20][20]; 
        int littercount = 0;
        int startrow = 0;
        int startcol = 0;
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                litterbit[r][c] = -1;
                if (classroom[r].charAt(c) == 'S') {
                    startrow = r;
                    startcol = c;
                } else if (classroom[r].charAt(c) == 'L') {
                    litterbit[r][c] = littercount;
                    littercount++;
                }
            }
        }

        int allCollected = (1 << littercount) - 1;
        if (littercount == 0)
            return 0;

        boolean[][][][] seen = new boolean[m][n][maxEnergy + 1][1 << littercount];

        Queue<State> que = new LinkedList<>();
        que.add(new State(startrow, startcol, maxEnergy, 0));
        seen[startrow][startcol][maxEnergy][0] = true;

        int moves = 0;

        while (!que.isEmpty()) {
            int currsize = que.size();

            while (currsize-- > 0) {
                State current = que.poll();

                if (current.collectedmask == allCollected)
                    return moves;
                if (current.energyleft == 0)
                    continue;

                for (int[] dir : directions) {
                    int nextrow = current.row + dir[0];
                    int nextcol = current.col + dir[1];

                    if (nextrow < 0 || nextrow >= m || nextcol < 0 || nextcol >= n)
                        continue;

                    char cell = classroom[nextrow].charAt(nextcol);
                    if (cell == 'X')
                        continue;

                    int nextenergy = current.energyleft - 1;
                    int nextmask = current.collectedmask;

                    if (cell == 'R') {
                        nextenergy = maxEnergy;
                    } else if (cell == 'L') {
                        nextmask |= (1 << litterbit[nextrow][nextcol]);
                    }

                    if (!seen[nextrow][nextcol][nextenergy][nextmask]) {
                        seen[nextrow][nextcol][nextenergy][nextmask] = true;
                        que.add(new State(nextrow, nextcol, nextenergy, nextmask));
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}