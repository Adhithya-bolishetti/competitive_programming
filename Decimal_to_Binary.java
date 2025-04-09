public class Decimal_to_Binary
{
    public static String reverse(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length-1;
        while(i<j) {
            char temp = charArray[i];
            charArray[i]=charArray[j];
            charArray[j]=temp;
            i++;
            j--;
        }
        return new String(charArray);
    }
	public static void main(String[] args) {
		int n = 10;
		String res = "";
		while(n != 0) {
		    if(n%2==1) res+="1";
		    else res+="0";
		    n/=2;
		}
		String ans = reverse(res);
		System.out.print(ans);
	}
}