import java.util.*;

public class sumOfSubsetsUsingRecursion {
    public static void sumOfSubsets(int[] arr, int index, int l, int[] subsets, int subsetSize,
                                    int targetSum, Set<String> seen, int[] count) {
        if (index == l) {
            int sum = 0;
            for (int i = 0; i < subsetSize; i++) {
                sum += subsets[i];
            }
            if (sum == targetSum) {
                int[] temp = Arrays.copyOf(subsets, subsetSize);
                Arrays.sort(temp);
                String key = Arrays.toString(temp);
                if (!seen.contains(key)) {
                    seen.add(key);
                    count[0]++;
                    System.out.print("[ ");
                    for (int i = 0; i < subsetSize; i++) {
                        System.out.print(subsets[i] + " ");
                    }
                    System.out.println("]");
                }
            }
            return;
        }

        sumOfSubsets(arr, index + 1, l, subsets, subsetSize, targetSum, seen, count);
        subsets[subsetSize] = arr[index];
        sumOfSubsets(arr, index + 1, l, subsets, subsetSize + 1, targetSum, seen, count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputArr = new int[n];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            inputArr[i] = sc.nextInt();
            set.add(inputArr[i]);
        }

        int duplicatesRemoved = n - set.size(); 
        System.out.println(duplicatesRemoved);

        int[] arr = new int[set.size()];
        int k = 0;
        for (int val : set) {
            arr[k++] = val;
        }

        int targetSum = sc.nextInt();
        int l = arr.length;
        int[] subsets = new int[l];
        int[] count = new int[1]; 
        Set<String> seen = new HashSet<>();

        sumOfSubsets(arr, 0, l, subsets, 0, targetSum, seen, count);

        if (count[0] == 0) {
            System.out.print("-1");
        }
    }
}
