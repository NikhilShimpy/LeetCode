//APPROACH 1
class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if(num == 0) return true;
        for(int i=0;i<num;i++){
            StringBuilder sb = new StringBuilder(i+"");
            String str = sb.reverse().toString();
            int val = Integer.parseInt(str);
            if(val+i == num) return true;
        }
        return false;
    }
}

//APPROACH 2
//OPTIMIZED
class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if (num == 0) return true;

        for (int i = num / 2; i <= num; i++) { // Start from num/2
            if (i + reverse(i) == num) return true;
        }
        return false;
    }

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;  // Extract last digit and append to rev
            n /= 10;  // Remove last digit from n
        }
        return rev;
    }
}

