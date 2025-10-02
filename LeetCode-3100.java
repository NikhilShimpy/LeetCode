class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = numBottles;   
        int emp = numBottles; 

        while (emp >= numExchange) {
            emp -= numExchange;   
            numExchange++;       
            total++;              
            emp++; 
        }

        return total;
    }
}
