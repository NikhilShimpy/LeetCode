class Solution {
    int mod = 1000000007;
    public int numberOfWays(String corridor) {
        int n = corridor.length();
        int sc = 0; //seat count

        ArrayList<Integer> seat = new ArrayList<>();
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seat.add(i);
            }
        }
        if(seat.size()%2 != 0 || seat.size() == 0) return 0;

        long res =1;
        int prev = seat.get(1);

        for(int i =2;i<seat.size();i+=2){
            int len = seat.get(i) - prev;
            res = (res*len) % mod;

            prev = seat.get(i+1);
        }

        return (int) res;

    }
}
