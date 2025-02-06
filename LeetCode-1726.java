class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> pm = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int ans = nums[i]*nums[j];
                pm.put(ans,pm.getOrDefault(ans,0)+1);
            }
        }
        int res=0;
        for(Map.Entry<Integer,Integer> entry : pm.entrySet()){
            int p = entry.getKey();
            int count = entry.getValue();
            if(count>=2){
                int combi = (count*(count-1))/2;
                res = res+combi*8;
            }
        }
        return res;
    }
}
