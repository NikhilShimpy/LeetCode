//solution
class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int i=0 , j=n-1;

        while(i<n && directions.charAt(i) == 'L'){
            i++;
        }
        while(j>=0 && directions.charAt(j) == 'R'){
            j--;
        }
        int count =0;
        while (i <= j){
            if(directions.charAt(i) != 'S'){
                count++;
            }
            i++;
        }
        return count;
    }
}
