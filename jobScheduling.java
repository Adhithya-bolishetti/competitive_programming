import java.util.*;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class itemComparator implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2) {
          if(j1.profit > j2.profit) return -1;
        else if(j1.profit < j2.profit) return 1;
        else return 0;
    }
}

public class Main {
    public static int jobScheduling(Job[] jobs) {
        Arrays.sort(jobs, new itemComparator());
        for(int i=0;i<jobs.length;i++){
            System.out.println(jobs[i].profit);
        }

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] hash = new int[maxDeadline + 1]; // index 1 to maxDeadline
        Arrays.fill(hash, -1);

        int totalProfit = 0;

        for (int i = 0; i < jobs.length; i++) {
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (hash[j] == -1) {
                    hash[j] = jobs[i].id;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {4, 5, 6, 6, 4, 2, 2, 2};
        int[] arr3 = {20, 60, 70, 65, 25, 80, 10, 22};
        int n = arr1.length;

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(arr1[i], arr2[i], arr3[i]);  // Fix: use arr3[i]
        }

        int ans = jobScheduling(jobs);
        System.out.println(ans);  // Output: Total maximum profit
    }
}
//Time complexity : O(nlongn + n*maxDeadline)
//Space complexity : O(maxDeadline)