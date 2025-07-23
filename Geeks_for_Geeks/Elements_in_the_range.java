class Solution {
    boolean check_elements(int arr[], int n, int A, int B) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : arr) {
            set.add(val);
        }
        
        for(int i=A; i<=B; i++) {
            if(!set.contains(i)) return false;
        }
        
        return true;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)
