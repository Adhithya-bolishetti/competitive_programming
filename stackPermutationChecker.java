import java.util.Stack;

public class StackPermutationChecker {
    
    static int isStackPermutation(int[] input, int[] output) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // pointer for output array
        
        for (int num : input) {
            stack.push(num);
            
            // Pop from stack if it matches the next output element
            while (!stack.isEmpty() && stack.peek() == output[j]) {
                stack.pop();
                j++;
            }
        }
        
        // If stack is empty, all elements matched
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] x = {1,2,3,4,5,6,7,8};
        int[] y = {1,2,3,5,6,4,7,8};
        int[] z = {2,5,6,3,4,1,7,8};

        System.out.println(isStackPermutation(x, y)); // should print 1
        System.out.println(isStackPermutation(x, z)); // should print 0
    }
}
