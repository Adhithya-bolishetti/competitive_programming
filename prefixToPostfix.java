import java.util.*;

public class PrefixToPostfix {

    public static String prefixToPostfix(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();
        int i = s.length()-1;
        while(i >= 0) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            }
            else {
                String t1 = st.peek();//first top
                st.pop();
                String t2 = st.peek();//second top
                st.pop();
                st.push(t1+t2+c);
            }
            i--;
        }
        return st.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Prefix expression:");
        String s = sc.nextLine();
        String ans = prefixToPostfix(s);
        System.out.println("Postfix expression: \n" + ans);
    }
}
