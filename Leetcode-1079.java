class Solution {
    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        char[] tileArr = tiles.toCharArray();

        java.util.Arrays.sort(tileArr);

        int[] count = new int[1]; 

        backtrack(tileArr, new StringBuilder(), used, count);
        return count[0];
    }

    private void backtrack(char[] tiles, StringBuilder current, boolean[] used, int[] count) {
        if (current.length() > 0) {
            count[0]++; 
        }

        for (int i = 0; i < tiles.length; i++) {
           
            if (used[i] || (i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            current.append(tiles[i]);

            backtrack(tiles, current, used, count);

            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}
