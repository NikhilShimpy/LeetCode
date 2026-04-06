class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        HashSet<String> obsset = new HashSet<>();
        for (int[] obs : obstacles) {
            String key = obs[0] + "_" + obs[1];
            obsset.add(key);
        }

        int x = 0;
        int y = 0;
        int maxdist = 0;

        int[] dir = {0, 1}; 

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) { 
                dir = new int[]{-dir[1], dir[0]};
            } else if (commands[i] == -1) {
                dir = new int[]{dir[1], -dir[0]};
            } else {
                for (int step = 0; step < commands[i]; step++) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];

                    String nextKey = newx + "_" + newy;

                    if (obsset.contains(nextKey)) {
                        break;
                    }
                    x = newx;
                    y = newy;
                }
            }

            maxdist = Math.max(maxdist, x * x + y * y);
        }

        return maxdist;
    }
}
