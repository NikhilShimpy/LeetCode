class Solution {
    public List<Integer> partitionLabels(String s) {
       int n = s.length();
       List<Integer> res = new ArrayList<>();

       int last[] = new int[26];
       for(int i =0;i<n;i++){
        last[s.charAt(i)-'a'] = i;
       }

       int i =0,start=0,end=0;

       while(i<n){
        end = Math.max(end, last[s.charAt(i) - 'a']);
        if(i == end){
            res.add(end-start+1);
            start = end+1;
        }
        i++;
       }
       return res;
    }
}

// another approach
// class Solution {
//     public List<Integer> partitionLabels(String s) {
//         List<Integer> list = new ArrayList<>();
//         dfs(s, list);
//         return list;
//     }
//     private void dfs(String s, List<Integer> list) {
//         if (s.length() == 0)
//             return;
//         char f = s.charAt(0);
//        int l = s.lastIndexOf(f);
//         for (int i = 0; i < l; i++) {
//             if (s.lastIndexOf(s.charAt(i)) <= l)
//                 continue;
//             l = s.lastIndexOf(s.charAt(i));
//         }
//         s = s.substring(l + 1);
//         list.add(l + 1);
//         dfs(s, list);
//     }
// }
