import java.util.*;

public class infixToPostfix
{
    public static int priority(char ch) {
        if(ch == '^') return 3;
        if(ch == '*' || ch == '/') return 2;
        if(ch == '+' || ch == '-') return 1;
        return -1;
    }
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";
        int i = 0;
        while(i<s.length()) {
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                ans += s.charAt(i);
            }
            else if(s.charAt(i) == '(') {
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    ans += st.peek();
                    st.pop();
                }
                st.pop();
            }
            else {
                while(!st.isEmpty() && priority(s.charAt(i)) <= priority(st.peek())) {
                    ans += st.peek();
                    st.pop();
                }
                st.push(s.charAt(i));
            }
            i++;
        }
        while(!st.isEmpty()) {
            ans += st.peek();
            st.pop();
        }
        return ans;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string :");
		String s = sc.nextLine();
		String ans = infixToPostfix(s);
		System.out.print("The string after Infix to Postfix conversion : \n"+ans);
	}
}