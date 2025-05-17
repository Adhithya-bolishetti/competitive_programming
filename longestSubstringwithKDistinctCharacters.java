import java.util.*;

class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int k = sc.nextInt();
		Solution sol = new Solution();
		int ans = sol.substringOfKDistintCharacters(s,k);
		System.out.print(ans);
	}
}
class Solution {
    public static int substringOfKDistintCharacters(String s, int k) {
        int maxlen = 0;
        for(int i=0;i<s.length();i++) {
            HashMap<Character,Integer> hm = new HashMap<>();
            for(int j=i;j<s.length();j++) {
                char ele = s.charAt(j);
                hm.put(ele,hm.getOrDefault(ele,0)+1);
                if(hm.size() <= k) {
                    maxlen = Math.max(maxlen,j-i+1);
                }
                else {
                    break;
                }
            }
        }
        return maxlen;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(n)