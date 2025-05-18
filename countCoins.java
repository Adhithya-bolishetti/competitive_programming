import java.util.*;

class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
		    arr[i] = sc.nextInt();
		}
		int val = sc.nextInt();
		Solution sol = new Solution();
		int ans = sol.countCoins(arr,val);
		System.out.print(ans);
	}
}
class Solution {
    public static int countCoins(int[] arr, int val) {
        int sum = 0;
        int count = 0;
        for(int i=arr.length-1;i>=0;i--) {
            while(sum + arr[i] <= val) {
                sum += arr[i];
                count++;
            }
            if(sum == val) {
                return count;
            }
        }
        return -1;
    }
}