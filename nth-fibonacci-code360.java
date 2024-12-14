import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int f1=1;
		int f2=1;
		if(n==1){
			System.out.print(1);
		}
		else if(n==2){
			System.out.print(2);
		}
		else{
		int sum=0;
		for(int i=1;i<=n-2;i++){
			sum=f1+f2;
			f1=f2;
			f2=sum;
		}
		System.out.print(sum);
		}
	}

}
