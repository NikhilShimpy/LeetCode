class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int prev = 0;
        int res =0; 
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            int curr = map.get(c);

            if (curr < prev) {
                res -= curr;
            } else {
                res += curr;
            }

            prev = curr;
        }
        return res;

    }
}

// Approach 2 ----> 100% faster

class Solution {
    public int romanToInt(String s) {

        int prev = 0;
        int res =0; 
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = value(s.charAt(i));
            if (curr < prev) {
                res -= curr;
            } else {
                res += curr;
            }
            prev = curr;
        }

        return res;

    }
    private static int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}


