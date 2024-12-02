class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int copy = x;
        int sum=0;  
        while(x>0)
        {
            int r=x%10;
            sum=sum*10+r;
            x=x/10;
            // System.out.println(y+" "+x);
        }
        if(sum==copy)
        {
            return true;
        }
        else
        return false;
    }
}