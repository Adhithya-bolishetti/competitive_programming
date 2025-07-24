import java.util.HashSet;
import java.util.Set;

class GfG {

    static boolean isSubset(int[] a,int[] b) {
        // Create a hash set and insert all elements of a
        Set<Integer> hashSet = new HashSet<>();
        for (int num : a) {
            hashSet.add(num);
        }

        // Check each element of b in the hash set
        for (int num : b) {
            if (!hashSet.contains(num)) {
                return false;
            }
        }

        // If all elements of b are found in the hash set
        return true;
    }

    public static void main(String[] args){
        int[] a = { 11, 1, 13, 21, 3, 7 };
        int[] b = { 11, 3, 7, 1 };

        if (isSubset(a, b)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
// Time complexity : O(m + n)
// Space complexity : O(m)