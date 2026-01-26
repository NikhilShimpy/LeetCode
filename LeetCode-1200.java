class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        
        int mindiff = Integer.MAX_VALUE;

        for(int i =0;i<n-1;i++){
            int diff = arr[i+1]-arr[i];
            if(mindiff>diff) mindiff = diff;

        }

        for(int j = 0;j<n-1;j++){
            int diff = arr[j+1]-arr[j];
            if(mindiff == diff){
                List<Integer> pair =  new ArrayList<>();
                pair.add(arr[j]);
                pair.add(arr[j+1]);
                res.add(pair);
            }
        }
        return res;
    }
}
