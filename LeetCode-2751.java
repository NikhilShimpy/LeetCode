class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] actualidx = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            actualidx[i] = i;
        }

        Stack<Integer> stack = new Stack<>();

        Arrays.sort(actualidx, (i, j) -> Integer.compare(positions[i], positions[j]));

        List<Integer> res = new ArrayList<>();
        
        for (int curridx : actualidx) {
            if (directions.charAt(curridx) == 'R') {
                stack.push(curridx);
            } else {
                while (!stack.isEmpty() && healths[curridx] > 0) {
                    int topIndex = stack.pop();

                    if (healths[topIndex] > healths[curridx]) {
                        healths[topIndex] -= 1;
                        healths[curridx] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[curridx]) {
                        healths[curridx] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        healths[curridx] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                res.add(healths[i]);
            }
        }

        return res;
    }
}
