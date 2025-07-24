class Solution {
    public void rearrange(int arr[]) {
        // code here
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i+=2) {
            int temp = arr[arr.length-1];
            for(int j=i; j<arr.length; j++) {
                int curr = arr[j];
                arr[j] = temp;
                temp = curr;
            }
        }
    }
}
// Time complexity : O(n ^ 2)