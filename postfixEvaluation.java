import java.util.*;

public class PostfixEvaluation {
    public static int evaluateExpression(String s) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                st.push(c - '0'); // fixed here
            }
            else {
                int top2 = st.pop();
                int top1 = st.pop();
                int sum = 0;
                if(c == '^') sum = (int)Math.pow(top1, top2); // added Math.pow for ^
                else if(c == '*') sum = top1 * top2;
                else if(c == '/') sum = top1 / top2;
                else if(c == '%') sum = top1 % top2;
                else if(c == '+') sum = top1 + top2;
                else if(c == '-') sum = top1 - top2;
                st.push(sum);
            }
        }
        return st.peek();
    }

    public static String infixToPostfix(String s) {
        String ans = "";
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                ans += c;
            }
            else if(c == '(') {
                st.push(c);
            }
            else if(c == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    ans += st.pop();
                }
                if (!st.isEmpty() && st.peek() == '(')
                    st.pop();
            }
            else {
                while(!st.isEmpty() && precedence(c) <= precedence(st.peek())) {
                    ans += st.pop();
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }

    public static int precedence(char c) {
        if(c == '^') return 3;
        if(c == '*' || c == '/' || c == '%') return 1;
        if(c == '+' || c == '-') return 2;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String postfix = infixToPostfix(s);
        int ans = evaluateExpression(postfix);
        System.out.println(postfix);
        System.out.println(ans);
    }
}
