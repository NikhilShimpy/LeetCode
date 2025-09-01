class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double gain = computeGain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        while (extraStudents > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            extraStudents--;
            double newGain = computeGain(pass, total);
            pq.offer(new double[]{newGain, pass, total});
        }

        double totalratio = 0.0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalratio += (double) pass / total;
        }

        return totalratio / classes.length;
    }

    private double computeGain(int pass, int total) {
        double curr = (double) pass / total;
        double newratio = (double) (pass + 1) / (total + 1);
        return newratio - curr;
    }
}
