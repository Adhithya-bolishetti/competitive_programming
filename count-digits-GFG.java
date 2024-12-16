class Solution {
    static int evenlyDivides(int n) {
        // code here
        int count=0;
        int temp=n;
        while(n>0){
            int r=n%10;
            if(r>0&&temp%r==0)
            count++;
            n=n/10;
        }
        return count;
    }
}