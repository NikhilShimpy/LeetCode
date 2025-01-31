class Solution {
    public String removeStars(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        s.toCharArray();
        for(int i =0;i<n;i++){
            if(s.charAt(i) != '*') str.append(s.charAt(i));
            else{
                str.deleteCharAt(str.length() - 1);
            }
        }
        return str.toString();
    }
}
