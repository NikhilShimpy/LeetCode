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
