import java.util.*;

public class PrefixToInfix {

    public static String prefixToInfix(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();
        int i = s.length()-1;
        while(i>=0) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            }
            else {
                String t1 = st.peek();
                st.pop();
                String t2 = st.peek();
                st.pop();
                st.push('('+t1+c+t2+')');
            }
            i--;
        }
        return st.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Prefix expression:");
        String s = sc.nextLine();
        String ans = prefixToInfix(s);
        System.out.println("Infix expression: \n" + ans);
    }
}
