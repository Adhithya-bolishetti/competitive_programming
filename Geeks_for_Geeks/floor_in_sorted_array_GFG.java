class Solution {

    static int findFloor(int[] arr, int k) {
        // write code here
         int n=arr.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > k) {
                //look for smaller index on the left
                high = mid - 1;
            } else {
                ans=mid;
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}
