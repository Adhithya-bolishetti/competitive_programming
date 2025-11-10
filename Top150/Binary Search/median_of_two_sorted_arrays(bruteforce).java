class Solution {
    public int[] combineArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] newArr = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                newArr[k++] = nums1[i++];
            } else {
                newArr[k++] = nums2[j++];
            }
        }

        while(i < n1) {
            newArr[k++] = nums1[i++];
        }

        while(j < n2) {
            newArr[k++] = nums2[j++];
        }

        return newArr;
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArr = combineArrays(nums1, nums2);
        if(newArr.length == 1) return newArr[0];
        int mid = newArr.length / 2;

        if(newArr.length % 2 == 1) {
            return (double) newArr[mid];
        } else {
            return (double) (newArr[mid] + newArr[mid - 1]) / 2;
        }

    }
}
// Time Complexity: O(n + m)
// Space Complexity: O(n + m)