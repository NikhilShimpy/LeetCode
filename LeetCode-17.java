  public class Solution {
        public static List<String> letterCombinations(String digits) {
            String map[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            List<String> res = new ArrayList<String>();
    
            if (digits.length()==0) return res;
            
            res.add("");
            for (int i=0; i<digits.length(); i++) 
                res = combine(map[digits.charAt(i)-'0'],res);
            
            return res;
        }
        
        public static List<String> combine(String digit, List<String> list) {
            List<String> res = new ArrayList<String>();
            
            for (int i=0; i<digit.length(); i++) 
                for (String x : list) 
                    res.add(x+digit.charAt(i));
    
            return res;
        }
    }
