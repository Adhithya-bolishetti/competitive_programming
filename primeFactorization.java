import java.util.*;

public class PrimeFactorization
{
    public static ArrayList<ArrayList<Integer>> primeFactorization(ArrayList<Integer> queries) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] spf = new int[((int)Math.pow(10,5))+1];
        int n=spf.length;
        for(int i=2;i<n;i++) {
            spf[i] = i;
        }
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(spf[i] == i) {
                for(int j=i*i;j<n;j+=i) {
                    if(spf[j]==j) {
                        spf[j] = i;
                    }
                }
            }
        }
        for(int val:queries) {
            ArrayList<Integer> temp = new ArrayList<>();
            while(val != 1) {
                temp.add(spf[val]);
                val /= spf[val];
            }
            list.add(temp);
        }
        return list;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> queries = new ArrayList<>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
		    queries.add(sc.nextInt());
		}
		ArrayList<ArrayList<Integer>> ans = primeFactorization(queries);
		for(int i=0;i<ans.size();i++) {
		    System.out.println("Prime factorization of "+queries.get(i)+" is "+ans.get(i));
		}
	}
}