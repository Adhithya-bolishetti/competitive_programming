import java.math.BigInteger;
class Solution {
    static BigInteger NthTerm(int N) {
        // code here
        if(N==1 || N==2) return BigInteger.valueOf(2);
        
        int x=0; 
        if(N%2 == 1) {
            x=(int)Math.pow(2,N/2);
        }
        else {
            x=(int)Math.pow(3,N/2-1);
        }
        
        BigInteger bb=BigInteger.TWO;
        for(int i=0;i<x-1;i++) {
            bb=(BigInteger.TWO.multiply(bb)); 
        }
        return bb;

    }
}
// Time complexity : O(N)
// Space complexity : O(1)