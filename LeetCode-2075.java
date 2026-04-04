class Solution {
            public String decodeCiphertext(String encodedText, int rows) {
        int l = encodedText.length();
        int columns = l / rows;

        StringBuilder oritxt = new StringBuilder();

        for (int col = 0; col < columns; col++) {
            for (int j = col; j < l; j += (columns + 1)) {
                oritxt.append(encodedText.charAt(j));
            }
        }

        while (oritxt.length() > 0 && 
               oritxt.charAt(oritxt.length() - 1) == ' ') {
            oritxt.deleteCharAt(oritxt.length() - 1);
        }

        return oritxt.toString();
    }
}
