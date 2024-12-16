import java.util.*;
class armstrongNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Solution sol=new Solution();
        boolean ans=sol.armstrongNumber(n);
        System.out.print(ans);
    }
}
class Solution{
    public boolean armstrongNumber(int n){
        int length=(int)Math.log10(n)+1;
        int sum=0;
        int copy=n;
        while(n>0){
            int r=n%10;
            int temp=(int)Math.pow(r,length);
            sum+=temp;
            n/=10;
        }
        if(sum==copy)
        return true;
        return false;
    } 
}