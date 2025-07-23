class Solution {
    // function to print alternate elements of an array
    public ArrayList<Integer> getAlternates(int arr[]) {
        // Code Here
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i+=2) {
            list.add(arr[i]);
        }
        
        return list;
    }
}
// Time complexity : O(n)
// Space complexity : O(n/2)