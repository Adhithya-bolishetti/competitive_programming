import java.util.*;

public class Main {
    public static int precedence(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/' || c == '%') return 2;
        if (c == '+' || c == '-') return 1;
        return -1;
    }

    public static String reverse(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return new String(arr);
    }

    public static String swapParantheses(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') arr[i] = ')';
            else if (arr[i] == ')') arr[i] = '(';
        }
        return new String(arr);
    }

    public static String infixToPrefix(String s) {
        s = reverse(s);
        s = swapParantheses(s);

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

        String res = sb.toString();
        res = reverse(res);

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = infixToPrefix(s);
        System.out.print(res);
    }
}
