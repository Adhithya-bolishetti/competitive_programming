class Solution {
    public static int countDivisors(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        return sum;
    }
    public static int sumOfDivisors(int n) {
        // code here
        int sum=0;
        while(n>0){
            int ans=countDivisors(n);
            sum+=ans;
            n--;
        }
        return sum;
    }
}