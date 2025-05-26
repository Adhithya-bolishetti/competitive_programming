import java.util.*;

public class Solution {

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int countFullBinaryTrees(int n) {
        if (n <= 0 || n % 2 == 0) return 0; 

        int k = (n - 1) / 2;
        long numerator = factorial(2 * k);
        long denominator = factorial(k + 1) * factorial(k);

        return (int)(numerator / denominator);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = countFullBinaryTrees(n);
        System.out.println(result);
    }
}
// Time complexity : O(n)
// Space complexity : O(1)