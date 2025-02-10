class Solution {
    public String reverseVowels(String s) {
        
        char[] arr = s.toCharArray(); 
        String v = "aeiouAEIOU";
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (left < right && v.indexOf(arr[left]) == -1) {
                left++;
            }
            while (left < right && v.indexOf(arr[right]) == -1) {
                right--;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }
}
