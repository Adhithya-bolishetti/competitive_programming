import java.util.*;

public class removeAdjacentDuplicates {
    public static int[] removeDuplicates(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (!st.isEmpty() && arr[i] == st.peek()) {
                st.pop();
            } else {
                st.push(arr[i]);
            }
        }

        // If the stack is empty, return an empty array
        if (st.isEmpty()) return new int[0];

        // Transfer stack to array
        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();

        System.out.println("Enter array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ans = removeDuplicates(arr, n);

        System.out.println("Elements after removing adjacent duplicates:");
        if (ans.length == 0) {
            System.out.println("[]");
        } else {
            System.out.print("[ ");
            for (int i=ans.length-1;i>=0;i--) {
                System.out.print(ans[i] + " ");
            }
            System.out.println("]");
        }
    }
}
