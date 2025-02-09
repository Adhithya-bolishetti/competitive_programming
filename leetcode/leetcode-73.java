class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        ArrayList<Integer> rowList=new ArrayList<>();
        ArrayList<Integer> colList=new ArrayList<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }

        int r1=0,c1=0;
        while(r1<rowList.size() && c1<colList.size()){
            for(int i=0;i<r;i++){
                matrix[i][colList.get(c1)]=0;
            }
            for(int j=0;j<c;j++){
                matrix[rowList.get(r1)][j]=0;
            }
            r1++;
            c1++;
        }

    }
}