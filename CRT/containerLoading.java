import java.util.*;

class Container {
    String id;
    int weight;
    public Container(String id, int weight) {
        this.id = id;
        this.weight = weight;
    }
}
class itemComparator implements Comparator<Container> {
    @Override
    public int compare(Container c1, Container c2) {
        if(c1.weight < c2.weight) return -1;
        else if (c1.weight > c2.weight) return 1;
        else return 0;
    }
}
class Main
{
    public static int countContainers(Container[] containers, int capacity) {
        Arrays.sort(containers, new itemComparator());
        int count = 0;
        int sum = 0;
        for(int i=0; i<containers.length; i++) {
            if(sum + containers[i].weight >= capacity) break;
            sum += containers[i].weight;
            count++;
        }
        return count;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Container[] containers = new Container[n];
		for(int i=0; i<n; i++) {
		    String  id = sc.next();
		    int weight = sc.nextInt();
		    containers[i] = new Container(id, weight);
		}
		int capacity = sc.nextInt();
		int ans = countContainers(containers, capacity);
		System.out.println(ans);
	}
}
// Time complexity : O(nlogn)
// Space complexity : O(1)