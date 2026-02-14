class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();

        if(numFriends == 1) return word;

        int i = bsp(word,n); //best starting point

        // int lp = n-(numFriends-1); //longest possible
        int cantake = Math.min(n-(numFriends-1), n-i);

        return word.substring(i,i+cantake);
    }
    private int bsp(String word , int n){
        int i =0,j=1;
        while(j<n){
            int k =0;

            //skip same char
            while( j+k < n && word.charAt(i+k) == word.charAt(j+k)) k++;

            if(j+k < n && word.charAt(j+k) > word.charAt(i+k)){
                // if j find best char
                i = j;
                j+=1;
            }else j = j+k+1;
        }
        return i;
    }
}
