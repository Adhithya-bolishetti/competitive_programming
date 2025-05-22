class Main{
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int prev2 = 0;
        int prev1 = 1;
        for(int i=2;i<=n;i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public static void main(String args[]) {
        int n = 5;
        int ans = fibonacci(n);
        System.out.print(ans);
    }
}
//Time complexity : O(n)
//Space complexity : O(1)