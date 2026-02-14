class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();

        int lcr[] = new int[n];
        int rcl[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R')
                lcr[i] = i;
            else if (dominoes.charAt(i) == '.')
                lcr[i] = i > 0 ? lcr[i - 1] : -1;
            else
                lcr[i] = -1;

            int j = n - i - 1;

            if (dominoes.charAt(j) == 'L')
                rcl[j] = j;
            else if (dominoes.charAt(j) == '.')
                rcl[j] = j < n - 1 ? rcl[j + 1] : -1;
            else
                rcl[j] = -1;
        }

        StringBuilder result = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int dlr = lcr[i] == -1 ? Integer.MAX_VALUE : i - lcr[i];
            int drl = rcl[i] == -1 ? Integer.MAX_VALUE : rcl[i] - i;

            if (dlr == drl)
                result.append('.');
            else if (dlr < drl)
                result.append('R');
            else
                result.append('L');
        }

        return result.toString();
    }
}
