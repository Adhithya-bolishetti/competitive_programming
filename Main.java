import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int[] a={1,2,3,5,4,6,9,8,7,10,11,14,13,12,15,16};
		int n=a.length-1;
		int s=0,e=s+1;
		HashSet<Integer> hs=new HashSet<>();
		while(s<n-1){
		    for(int i=s;i<n-1;i++){
		        if(a[i]>a[i+1]){
		            s=i;
		            break;
		        }
		    }
		    for(int i=s+1;i<n-1;i++){
		        if(a[i]<a[i+1]){
		            e=i;
		            break;
		        }
		    }
		    int maxlen=e-s+1;
		   if(!hs.contains(maxlen)){
		        hs.add(maxlen);
		        for(int i=s;i<=e;i++){
		            System.out.print(a[i]+" ");
		        }
		        System.out.println();
		   }
		    s=e+1;
		}
	}
}
