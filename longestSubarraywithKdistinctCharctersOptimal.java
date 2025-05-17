import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        Solution sol = new Solution();
        int ans = sol.substringOfKDistinctCharacters(s, k);
        System.out.print(ans);
    }
}

class Solution {
    public int substringOfKDistinctCharacters(String s, int k) {
        int maxlen = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            if (freq.size() > k) {
                char leftChar = s.charAt(l);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                l++;
            }
            if(freq.size() <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
        }
        return maxlen;
    }
}
