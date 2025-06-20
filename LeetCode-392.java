class Solution {
    public boolean isSubsequence(String s, String t) {
       int i=0,j=0;
       int sl = s.length();
       while(i < sl && j < t.length()){
        if(s.charAt(i) == t.charAt(j)){
            i++;
        }
        j++;
       }
       return (i == sl);
    }
}
