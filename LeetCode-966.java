class Solution {
    Set<String> exactword = new HashSet<>();               
    Map<String, String> casemap = new HashMap<>(); // lowercase : original word
    Map<String, String> vowelmap = new HashMap<>();           

    private String toLower(String s) {
        return s.toLowerCase();
    }

    private String maskVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private String checkForMatch(String query) {
        //1 exact match
        if (exactword.contains(query)) {
            return query;
        }
        //2 case insens.
        String lowerquery = toLower(query);
        if (casemap.containsKey(lowerquery)) {
            return casemap.get(lowerquery);
        }
        //3 vowel-insensitive
        String vowelinw = maskVowels(lowerquery);
        if (vowelmap.containsKey(vowelinw)) {
            return vowelmap.get(vowelinw);
        }

        // 4
        return "";
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        exactword.clear();
        casemap.clear();
        vowelmap.clear();

        for (String word : wordlist) {
            exactword.add(word);

            String lowerword = toLower(word);
            casemap.putIfAbsent(lowerword, word);  

            String maskedWord = maskVowels(lowerword);
            vowelmap.putIfAbsent(maskedWord, word); 
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = checkForMatch(queries[i]);
        }
        return res;
    }
}
