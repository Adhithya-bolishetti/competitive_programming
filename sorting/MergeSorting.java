import java.util.*;
public class MergeSorting
{
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
		}
		int low=0;
		int high=arr.length-1;
	    Sorting sort=new Sorting();
	    sort.mergeSort(arr,low,high);
	    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }
	}
}
class Sorting{
    public void mergeSort(int[] arr, int low, int high){
        if(low>=high) return;
        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public void merge(int[] arr, int low, int mid, int high){
        int[] sarr=new int[high-low+1];
        int ind=0;
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                sarr[ind]=arr[left];
                ind++;
                left++;
            }
            else{
                sarr[ind]=arr[right];
                ind++;
                right++;
            }
        }
        while(left<=mid){
            sarr[ind]=arr[left];
            ind++;
            left++;
        }
        while(right<=high){
            sarr[ind]=arr[right];
            ind++;
            right++;
        }
        System.arraycopy(sarr, 0, arr, low, sarr.length);
    }
}
