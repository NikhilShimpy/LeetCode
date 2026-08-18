class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!map.containsKey(sortedStr)) {
                //sorted str ko map me dalo
                map.put(sortedStr, new ArrayList<>());
            }
            //agar sorted str already hai to list me add kr do
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
