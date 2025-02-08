class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        HashSet<Integer> arr = new HashSet<>();
        for(int nums : a) arr.add(nums);
        
        for(int nums : b) arr.add(nums);
        
        // remove(arr);
        ArrayList<Integer> list = new ArrayList<>(arr);
        Collections.sort(list);
        return list;
    }
}