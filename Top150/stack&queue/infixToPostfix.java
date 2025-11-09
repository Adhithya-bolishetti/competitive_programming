import java.util.*;

public class Main {
    public static int precedence(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/' || c == '%') return 2;
        if (c == '+' || c == '-') return 1;
        return -1;
    }

    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ((c >= 'A' && c <= 'Z') || 
                (c >= 'a' && c <= 'z') || 
                (c >= '0' && c <= '9')) {
                sb.append(c);
            } 
            else if (c == '(') {
                st.push(c);
            } 
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                if (st.isEmpty()) return "Invalid Expression";
                st.pop(); 
            } 
            else {
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(c)) {
                    if (c == '^' && precedence(st.peek()) == precedence(c)) break;
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            if (st.peek() == '(') return "Invalid Expression";
            sb.append(st.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = infixToPostfix(s);
        System.out.print(res);
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)