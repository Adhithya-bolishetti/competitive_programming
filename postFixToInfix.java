import java.util.*;

public class postfixToInfix {

    public static String postfixToInfix(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();
        int i = 0;
        while(i<s.length()) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            }
            else {
                String t1 = st.peek();
                st.pop();
                String t2 = st.peek();
                st.pop();
                st.push('('+t2+c+t1+')');
            }
            i++;
        }
        return st.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Postfix expression:");
        String s = sc.nextLine();
        String ans = postfixToInfix(s);
        System.out.println("Infix expression: \n" + ans);
    }
}
