class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while(l < r) {
            while(numbers[l] + numbers[r] > target) {
                r--;
            }
            while(numbers[l] + numbers[r] < target) {
                l++;
            }
            if(numbers[l] + numbers[r] == target) {
                return new int[]{l+1, r+1};
            }
        }

        return new int[0];
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)