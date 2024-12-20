class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
    long x=1;
    long i=1;
    ArrayList<Long> list=new ArrayList<>();
    while(x<=n){
         list.add(x);
         i++;
         x=x*i;
    }
    return list;
    }
}