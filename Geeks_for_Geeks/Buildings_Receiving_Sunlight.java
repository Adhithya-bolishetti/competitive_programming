class Solution {
    public static int longest(int arr[]) {
        if (arr.length == 0) return 0;

        int count = 1; // First building always receives sunlight
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= max) {
                count++;
                max = arr[i];
            }
        }

        return count;
    }
}
// Time complexity : O(n)
// Space complexity : O(1)