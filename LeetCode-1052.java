class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int  n = customers.length;
        int max  = 0 , curr = 0; //unsatisfy customer 

        for(int  i =0;i<minutes;i++){
            // if(grumpy[i] == 1) max += customers[i];
            curr += customers[i] * grumpy[i]; // if ki jagah 
        }

        max = curr;
        int i =0 ,j = minutes;

        while(j<n){
            curr += customers[j] * grumpy[j]; // grumpy hai to
            curr -= customers[i] * grumpy[i]; // remove kr rhe i ko jo window me nhi hai

            max = Math.max(max,curr);
            i++;j++;
        }
        int total = max;
        for(int k = 0;k<n;k++){
            if(grumpy[k] == 0) total += customers[k];
        }

        return total;
    }
}
