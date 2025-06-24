class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i =0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int j  =0;j<ransomNote.length();j++){
            char c = ransomNote.charAt(j);
            int count = map.getOrDefault(c, 0);
            if (count <= 0) {
                return false;
            }

            map.put(c, count - 1);
        }
        return true;
    }
}
