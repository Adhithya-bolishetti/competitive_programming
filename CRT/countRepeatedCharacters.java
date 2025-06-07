import java.util.*;

public class Solution {
    public static Map<Character, Integer> countChars(char[] arr, int low, int high) {
        Map<Character, Integer> freq = new HashMap<>();

        if (low == high) {
            freq.put(arr[low], 1);
            return freq;
        }

        int mid = (low + high) / 2;

        Map<Character, Integer> left = countChars(arr, low, mid);
        Map<Character, Integer> right = countChars(arr, mid + 1, high);

        for (Map.Entry<Character, Integer> entry : right.entrySet()) {
            left.put(entry.getKey(), left.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim()); 
        String s = sc.nextLine().trim();

        char[] arr = s.toCharArray();
        Map<Character, Integer> freq = countChars(arr, 0, arr.length - 1);

        int repeatedCount = 0;
        for (int val : freq.values()) {
            if (val > 1) repeatedCount++;
        }

        System.out.println(repeatedCount);
    }
}
// Time complexity : O(nlogn)
// Space complexity : O(n)