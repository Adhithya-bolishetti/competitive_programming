import java.util.*;

public class PostfixToPrefix {

    public static String postfixToPrefix(String s) {
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
                st.push(c+t2+t1);
            }
            i++;
        }
        return st.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Postfix expression:");
        String s = sc.nextLine();
        String ans = postfixToPrefix(s);
        System.out.println("Prefix expression: \n" + ans);
    }
}
