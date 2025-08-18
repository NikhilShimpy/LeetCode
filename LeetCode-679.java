class Solution {
    private static final double eps = 0.1; 
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return solve(nums);
    }

    private boolean solve(List<Double> cards) {
        if (cards.size() == 1) {
            return Math.abs(cards.get(0) - 24) <= eps;
        }

        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (i == j) continue;

                List<Double> temp = new ArrayList<>();
                for (int k = 0; k < cards.size(); k++) {
                    if (k != i && k != j) {
                        temp.add(cards.get(k));
                    }
                }

                double a = cards.get(i);
                double b = cards.get(j);
                List<Double> possval = new ArrayList<>();
                possval.add(a + b);
                possval.add(a - b);
                possval.add(b - a); 
                possval.add(a * b);

                if (Math.abs(b) > 0.0) {
                    possval.add(a / b);
                }
                if (Math.abs(a) > 0.0) {
                    possval.add(b / a); 
                }

                for (double val : possval) {
                    temp.add(val);
                    if (solve(temp)) return true; 
                    temp.remove(temp.size() - 1); 
                }
            }
        }

        return false;
    }
}
