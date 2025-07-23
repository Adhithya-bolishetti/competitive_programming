class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
        d = d % arr.length;
        
        int[] dup = new int[d];
        for(int i=0; i<d; i++){
            dup[i] = arr[i];
        }
        int k = 0;
        for(int i=d; i<arr.length; i++) {
            arr[k++] = arr[i]; 
        }
        for(int i=0; i<d; i++) {
            arr[k++] = dup[i];
        }
    }
}
// Time complexity : O(n)
// Space complexity : O(d)