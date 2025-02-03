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
		Sorting ss=new Sorting();
		ss.sort(arr,n);
	}
}
class Sorting{
    public void sort(int[] arr,int n){
        for(int i=0;i<n;i++){
           int j=i;
           while(j>0 && arr[j-1]>arr[j])
           {
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
           }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
