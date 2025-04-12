class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long temp  = n;
        if(n < 0) {
            x = 1/x;
            temp = -temp;
        }
        while(temp > 0) {
            if(temp%2 == 1) {
                ans = ans * x;
                temp--;
            }
            x *= x;
            temp /= 2;
        }
        return ans;
    }
}