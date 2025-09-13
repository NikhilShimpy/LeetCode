class Solution {
    public int maxFreqSum(String s) {
        char ch[] = new char[26];
        int a=0,e=0,i=0,o=0,u=0;
        for(int k =0;k<s.length();k++){
            char c = s.charAt(k);
            int idx = c - 97;
            if(c == 'a'){
                a++;
            }else if(c == 'e'){
                e++;
            }else if(c == 'i'){
                i++;
            }else if(c == 'o'){
                o++;
            }else if(c == 'u'){
                u++;
            }else{
                ch[idx]++;
            }
        }
        int maxc = 0;
        for(int j=0;j<26;j++){
            maxc = Math.max(maxc,ch[j]);
        }
        int maxv = Math.max(a, Math.max(e, Math.max(i, Math.max(o, u))));
        return maxv + maxc;
    }
}
