class Solution {
     public static int findLCM(int a,int b){
        return Math.abs(a*b)/findGCD(a,b);
    }
    public static int findGCD(int a,int b){
       while(a>0 && b>0){
            if(a>b){
            a=a%b;
        }
        else{
            b=b%a;
        }
       }
       if(a>b){
           return a;
       }
       return b;
    }
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int lcm=findLCM(a,b);
        int gcd=findGCD(a,b);
        return new int[]{lcm,gcd};
    }
}