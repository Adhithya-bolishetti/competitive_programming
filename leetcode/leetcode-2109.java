class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();
        int k=0;
        for(int i=0;i<s.length();i++){
            if(k<spaces.length && i==spaces[k]){
                sb.append(" ");
                k++;
            }
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}