class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;
        while(true){
            if(ipdbt(num,t)){
                return num;
            }
            num++;
        }
    }
    private boolean ipdbt(int num, int t){
        int prod = 1;
        int temp = num;
        while(temp > 0){
            int dig = temp%10;
            prod *= dig;
            temp /= 10;
        }
        return prod % t == 0;
    }
}


