import java.util.*;

public class prime_factors_optimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i == 0) {
                list.add(i);
                while(n%i == 0) {
                    n /= i;
                }
            }
        }
        if(n != 1) list.add(n);
        for(int val:list) {
            System.out.print(val+" ");
        }
    }
}
