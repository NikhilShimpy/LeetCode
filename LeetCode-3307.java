// RECURSION

class Solution {
    public char kthCharacter(long k, int[] operations) {
       
        if (k == 1) {
            return 'a';
        }

        int n = operations.length;
        int optype = 0; 
        long len = 1;
        long newk = k;

        for (int i = 0; i < n; i++) {
            len *= 2;
            if (len >= k) { 
                optype = operations[i];
                newk = k - len / 2; 
                break;
            }
        }

        char res = kthCharacter(newk, operations);

        if (optype == 0) 
            return res;

        if (res == 'z') 
            return 'a';

        return (char) (res + 1); 
    }
}


//bit man.
// class Solution {
//     public char kthCharacter(long k, int[] operations) {
//         int i = (int) (Math.ceil(Math.log(k) / Math.log(2))) - 1;
//         int count = 0;

//         while (k > 1) {
//             if (k > (1L << i)) {
//                 if (operations[i] == 1) {
//                     count++;
//                 }
//                 k -= (1L << i);
//             }
//             i--;
//         }

//         return (char) ('a' + (count % 26));
//     }
// }
