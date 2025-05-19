import java.util.*;

public class Main
{
	public static void main(String[] args) {
		int[] arr = {900,945,955,1100,1500,1800};
		int[] dep = {920,1200,1130,1150,1900,2000};
		int maxcount = 0;
		for(int i=0;i<arr.length;i++) {
		    int count = 1;
		    for(int j=i+1;j<arr.length;j++) {
		        if((arr[i]>=arr[j] && arr[i]<=dep[j]) || (arr[j]>=arr[i] && arr[j]<=dep[i]))
                {
                    count++;
                }
                maxcount = Math.max(maxcount,count);
		    }
		}
		System.out.print(maxcount);
	}
}
//Time complexity : O(n^2)
//Space complexity : O(1)