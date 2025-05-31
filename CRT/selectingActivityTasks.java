import java.util.*;

class Activity {
    String id;
    int startTime;
    int endTime;
    public Activity(String id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
class itemComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        if(a1.endTime < a2.endTime) return -1;
        else if(a1.endTime > a2.endTime) return 1;
        else return 0;
    }
}
class Main
{
    public static int countActivities(Activity[] activities) {
        Arrays.sort(activities, new itemComparator());
        int count = 1;
         int lastEnd = activities[0].endTime;
        for(int i = 1; i < activities.length; i++) {
            if(activities[i].startTime >= lastEnd) {
                count++;
                lastEnd = activities[i].endTime;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
        Activity[] activities = new Activity[n];
		for(int i=0; i<n; i++) {
		    String  id = sc.next();
		    int startTime = sc.nextInt();
		    int endTime = sc.nextInt();
		    activities[i] = new Activity(id, startTime, endTime);
		}
		int ans = countActivities(activities);
		System.out.println(ans);
	}
}
// Time complexity : O(nlogn)
// Space complexity : O(1)