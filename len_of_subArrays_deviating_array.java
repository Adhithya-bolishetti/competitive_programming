import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int[] a={1,2,3,5,4,6,9,8,7,10};
		int n=a.length-1;
		int s=0,e=s+1;
		while(s<n){
		    for(int i=s;i<n;i++){
		        if(a[i]>a[i+1]){
		            s=i;
		            break;
		        }
		    }
		    for(int i=s+1;i<n;i++){
		        if(a[i]<a[i+1]){
		            e=i;
		            break;
		        }
		    }
		    if(a[s]>a[e]){
		        System.out.println("len: "+(e-s+1));
		        for(int i=s;i<=e;i++){
		            System.out.print(a[i]+" ");
		        }
		        System.out.println();
		    }
		    s=e+1;
		}
	}
}
