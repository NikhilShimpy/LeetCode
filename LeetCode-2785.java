class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char ch : arr) {
            if (isVowel(ch)) {
                sb.append(ch);
            }
        }

        char[] varr = sb.toString().toCharArray();
        Arrays.sort(varr);
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = varr[idx++];
            }
        }
        return new String(arr);
    }

    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) >= 0;
    }
}
