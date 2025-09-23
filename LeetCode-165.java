class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = 0, len2 = 0;
        int n1 = version1.length(), n2 = version2.length();
        
        while (len1 < n1 || len2 < n2) {
            int num1 = 0;
            while (len1 < n1 && version1.charAt(len1) != '.') {
                num1 = num1 * 10 + (version1.charAt(len1) - '0');
                len1++;
            }
            
            int num2 = 0;
            while (len2 < n2 && version2.charAt(len2) != '.') {
                num2 = num2 * 10 + (version2.charAt(len2) - '0');
                len2++;
            }
            
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
            
            // Skip dots
            len1++;
            len2++;
        }
        
        return 0;
    }
}
