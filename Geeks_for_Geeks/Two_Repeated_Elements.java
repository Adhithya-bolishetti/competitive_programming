class Solution {
    public int[] twoRepeated(int[] arr) {
        // code here
        int[] count = new int[arr.length];
        int[] result = new int[2];
        int index = 0;
        for (int i = 0; i < arr.length; i++) 
        {
            count[arr[i]]++;
            if (count[arr[i]] == 2) 
            {
                result[index++] = arr[i];
            }
        }
        return result;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)