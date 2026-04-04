// Rec + Memo

class Solution {
    public int punishmentNumber(int n) {
        int pnum = 0;
        for (int currnum = 1; currnum <= n; currnum++) {
            int sqrnum = currnum * currnum;
            if (check(sqrnum, 0, currnum)) {
                pnum += sqrnum;
            }
        }
        return pnum;
    }

     public boolean check(int num, int currnum, int target) {
        if (num == 0) {
            return currnum == target;
        }
        
        return check(num / 10, currnum + num % 10, target) ||
               check(num / 100, currnum + num % 100, target) ||
               check(num / 1000, currnum + num % 1000, target) ||
               check(num / 10000, currnum + num % 10000, target);
    }

}



// class Solution {
//     public int punishmentNumber(int n) {
//         int[] arr = {1,9,10,36,45,55,82,91,99,100,235,297,369,370,379,414,657,675,703,756,792,909,918,945,964,990,991,999,1000};

//         int sum = 0;
//         for(int i=0;i<arr.length;i++){
//             if(arr[i]<=n) sum += arr[i]*arr[i];
//             else if(arr[i]>n) break;
//         }
        
//         return sum;
//     }
// }
