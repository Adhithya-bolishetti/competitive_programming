import java.util.*;

public class InfixToPrefix {

    // Reverse a string
    public static String reverse(String s) {
        char[] carr = s.toCharArray();
        int i = 0;
        int j = carr.length - 1;
        while (i < j) {
            char temp = carr[i];
            carr[i] = carr[j];
            carr[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(carr);
    }

    // Swap '(' with ')' and vice versa
    public static String swap(String s) {
        char[] carr = s.toCharArray();
        for (int i = 0; i < carr.length; i++) {
            if (carr[i] == '(') carr[i] = ')';
            else if (carr[i] == ')') carr[i] = '(';
        }
        return String.valueOf(carr);
    }

    // Operator precedence
    public static int priority(char ch) {
        if (ch == '^') return 3;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return -1;
    }

    // Convert infix to prefix
    public static String infixToPrefix(String s) {
        Stack<Character> st = new Stack<>();
        s = reverse(s);
        s = swap(s);
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                ans.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                if (!st.isEmpty()) st.pop(); // Remove '('
            } else {
                // For right-associative '^'
                while (!st.isEmpty() && priority(c) < priority(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return reverse(ans.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter infix expression:");
        String s = sc.nextLine();
        String ans = infixToPrefix(s);
        System.out.println("Prefix expression: \n" + ans);
    }
}
