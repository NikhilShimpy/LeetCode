class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
       int max = 0;
       int n = candies.length;
       List<Boolean> list = new ArrayList<>();
       for(int i =0;i<n;i++){
        max = Math.max(max,candies[i]);
       }
       for(int j =0;j<n;j++){
        if(max<=candies[j]+extraCandies){
            list.add(true);
        }else{
            list.add(false);
        }
       }
       return list;
    }
}
