class Solution {
    public void reverseArray(int arr[]) {
        // code here
        reverse(0,arr);
    }
    static void reverse(int i,int arr[]){
        int n=arr.length;
        if(i>=n/2)
        {
            return;
        }
        int temp=arr[i];
        arr[i]=arr[n-i-1];
        arr[n-i-1]=temp;
        reverse(i+1,arr);
    }
}