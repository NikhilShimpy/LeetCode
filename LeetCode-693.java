class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x+1)) == 0;

        // String b = Integer.toBinaryString(n);
        // for(int i =0;i<b.length()-1;i++){
        //     if(b.charAt(i)==b.charAt(i+1)) return false;
        // }
        // return true;
    }
}
