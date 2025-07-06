class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n ==1) return 1;
        int max = 0;
        Set<Character> map = new HashSet<>();
        int start =0;

        for(int end=0;end<n;end++){
            char ch = s.charAt(end);
            while(map.contains(ch)){
                map.remove(s.charAt(start));
                start++;
            }
            map.add(ch);
            max = Math.max(max,end-start+1);
        }
        return max;
    }
}

// approach 2 ---> optimize 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128]; 
        int max = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            start = Math.max(start, index[ch]);
            max = Math.max(max, end - start + 1);
            index[ch] = end + 1;
        }

        return max;
    }
}
