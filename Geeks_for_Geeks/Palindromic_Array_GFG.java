/*Complete the Function below*/
class Solution {
    public static boolean checkPalindrome(int num) {
        int temp = num;
        int sum = 0;
        while(num > 0) {
            int r = num % 10;
            sum = sum * 10 + r;
            num /= 10;
        }
        
        if(sum == temp) return true;
        return false;
    }
    
    public static boolean isPalinArray(int[] arr) {
        // add code here.
        for(int i=0; i<arr.length; i++) {
            if(!checkPalindrome(arr[i])) return false;
        }
        
        return true;
    }
}
// Time complexity : O(n * logm)
// Space complexity : O(1)