class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int minHour = 0;

        // Initial penalty = count of 'Y'
        int penalty = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;

        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                minHour = i + 1;
            }
        }

        return minHour;
    }
}
