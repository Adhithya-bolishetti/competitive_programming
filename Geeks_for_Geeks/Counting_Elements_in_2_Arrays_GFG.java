class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        Arrays.sort(b);
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<a.length; i++) {
            int count = 0;
            for(int j=0; j<b.length; j++) {
                if(b[j] <= a[i]) count++;
                else break;
            }
            list.add(count);
        }
        return list;
        
    }
}
// Time complexity : O(mlogm + (n*m))
// Space complexity : O(n)