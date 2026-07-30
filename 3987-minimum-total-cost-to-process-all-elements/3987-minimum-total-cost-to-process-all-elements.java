class Solution {
    public int minimumCost(int[] nums, int k) {
        final long mod = 1_000_000_007L;
        final long inv = 500000004L;

        long resource = k;
        long ops = 0; long res = 0;

        for(int x : nums){
            if(resource < x){
                long need = x - resource;
                long add = (need + k - 1L) / k;

                long first  = (ops + 1) % mod;
                long last = (ops + add) % mod;
                long cnt = add % mod;

                long cost = ((first + last) % mod) * cnt % mod;
                cost = cost * inv % mod;

                res = (res + cost)%mod;

                ops += add ;
                resource += add * (long) k;
            }
            resource -= x;
        }
        return (int) res;
    }
}