import java.util.*;
public class BubbleSort
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
        for(int i=n-1;i>=1;i--){
           for(int j=0;j<i;j++){
               if(arr[j]>arr[j+1]){
                   int temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
               }
           }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
