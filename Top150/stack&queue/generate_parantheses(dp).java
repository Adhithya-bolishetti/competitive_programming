import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();

        dp.add(Arrays.asList("")); 

        for (int i = 1; i <= n; i++) {
            List<String> current = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                for (String inside : dp.get(j)) {
                    for (String outside : dp.get(i - 1 - j)) {
                        current.add("(" + inside + ")" + outside);
                    }
                }
            }

            dp.add(current);
        }

        return dp.get(n);
    }
}
//Time Complexity: O(4^n / sqrt(n))
//Space Complexity: O(4^n / sqrt(n))