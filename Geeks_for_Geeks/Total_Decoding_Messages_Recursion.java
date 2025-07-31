class Solution {
     public int decodeHelper(String digits, int index) {
        if (index >= digits.length()) {
            return 1;
        }

        if (digits.charAt(index) == '0') {
            return 0;
        }

        int ways = 0;
        if(digits.charAt(index) != '0'){
            ways = decodeHelper(digits, index + 1);
        }

        if (index + 1 < digits.length() && ((digits.charAt(index) == '1'
            && digits.charAt(index+1) <= '9') || (digits.charAt(index) == '2'
            && digits.charAt(index+1) <= '6'))) {
                ways += decodeHelper(digits, index + 2);
            }

        return ways;
    }
    public int countWays(String digits) {

        if(digits == null || digits.length() == 0 || digits.charAt(0) == '0') return 0;
        
        return decodeHelper(digits, 0);
    }
}