// Longest Valid Parentheses - LeetCode
class Solution {
    public int longestValidParentheses(String s) {
        int stack[] = new int[s.length()+1];
        int idx = -1;
        int max =0;
        stack[++idx] = -1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c == '('){
                stack[++idx] =i;
            }else{
                idx--;
                if(idx == -1){
                    stack[++idx] =i;
                }else{
                    max = Math.max(max,i-stack[idx]);
                }
            }
            
        }
        return max;
    }
}
