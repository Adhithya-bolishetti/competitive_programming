class Solution {
    public List<Integer> generateRows(int rows){
        List<Integer> l=new ArrayList<>();
        int ans=1;
        l.add(ans);
        for(int i=1;i<rows;i++){
            ans*=(rows-i);
            ans/=i;
            l.add(ans);
        }
        return l;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
           list.add(generateRows(i));
        }
        return list;
    }
}