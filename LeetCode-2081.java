class Solution {

    private boolean isPalindromeInBaseK(long num, int k) {
      
        int[] digits = new int[64];  
        int len = 0;
        
        while (num > 0) {
            digits[len++] = (int)(num % k);
            num /= k;
        }

        for (int i = 0; i < len / 2; i++) {
            if (digits[i] != digits[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public long kMirror(int k, int n) {
        long sum = 0;
        int length = 1;

        while (n > 0) {
            int halfLen = (length + 1) / 2;
            long start = (long) Math.pow(10, halfLen - 1);
            long end = (long) Math.pow(10, halfLen);

            for (long half = start; half < end; half++) {
                
                long pal = buildPalindrome(half, length % 2 == 1);

                if (isPalindromeInBaseK(pal, k)) {
                    sum += pal;
                    n--;
                    if (n == 0) {
                        return sum;
                    }
                }
            }
            length++;
        }
        return sum;
    }

    private long buildPalindrome(long half, boolean oddLength) {
        long pal = half;
        if (oddLength) half /= 10;
        while (half > 0) {
            pal = pal * 10 + (half % 10);
            half /= 10;
        }
        return pal;
    }
}
