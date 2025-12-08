class Solution {
    public int countTriples(int n) {
        int count = 0;

        for(int a=1;a<n-1;a++){
            for(int b=a+1;b<n;b++){
               int sum = a*a + b*b;
               int c  = (int) Math.sqrt(sum);

               if(c*c == sum && c<=n) count += 2;
            }
        }
        return count;

    }
}
