
class Solution {
    public void swapKth(List<Integer> arr, int k) {
        // code here
        int l = 0 + k - 1;
        int r = arr.size() - k;
        int temp = arr.get(l);
        arr.set(l,arr.get(r));
        arr.set(r,temp);
    }
}
// Time complexity : O(1)