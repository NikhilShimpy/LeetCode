class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(!map.containsKey(cs)){
                if(map.containsValue(ct) ) return false;
                map.put(cs,ct);
            }else{
                if(map.get(cs) != ct) return false;
                
                
            }
        }
        return true;
    }
}
