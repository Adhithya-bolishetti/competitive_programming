import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
		}
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<arr.length;i++){
		    hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
		}
		int t=sc.nextInt();
		while(t-->0){
		    int n1=sc.nextInt();
		    System.out.print(hm.get(n1));
		}
	}
}