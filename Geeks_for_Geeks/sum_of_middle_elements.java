// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int n1 = arr1.length;
        int n2 = arr2.length;
        int totalLength = n1 + n2;
        int[] sortedArr = new int[totalLength];
        
        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2) {
            if(arr1[i] < arr2[j]) sortedArr[k++] = arr1[i++];
            else sortedArr[k++] = arr2[j++];
        }
        while(i < n1) sortedArr[k++] = arr1[i++];
        while(j < n2) sortedArr[k++] = arr2[j++];
        
        if(totalLength % 2 == 0) {
            int sum = sortedArr[totalLength/2 - 1] + sortedArr[totalLength/2];
            return sum;
        }
        return sortedArr[totalLength/2];
    }
}
// Time complexity : O(n)
// Space complexity : O(n)