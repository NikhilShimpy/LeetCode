class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;   // total bottles drunk
        int empties = numBottles; // empty bottles after drinking

        while (empties >= numExchange) {
            int newFull = empties / numExchange;  // how many new full bottles we get
            total += newFull;                     // drink them
            empties = empties % numExchange + newFull; // leftover empties + new ones
        }

        return total;
    }
}
