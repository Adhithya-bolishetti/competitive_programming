import java.util.HashSet;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet <Integer> hs=new HashSet<>();
        for(int i=0;i<banned.length;i++){
            hs.add(banned[i]);
        }
        int sum=0;
        int count=0;
        for(int i=1;i<=n;i++){
            if(!hs.contains(i)){
                System.out.print(i);
                sum+=i;
                 if(sum>maxSum) break;
                count++;
            }
        }
        return count;
    }
}