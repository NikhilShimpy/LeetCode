//Approach 1
class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words){
            StringBuilder sb = new StringBuilder(s).reverse();
            if(s.equals(sb.toString())) return s;

        }
        return "";
    }
} 

//Approach 2 
public class Solution {
   
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (check(s)) {
                return s;
            }
        }
        return "";
    }
 public boolean check(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    
}


