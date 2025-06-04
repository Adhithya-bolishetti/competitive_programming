import java.io.*;
import java.util.*;

class Process {
    String name;
    int arrivalTime, burstTime, priority, completionTime;
    boolean completed;

    Process(String name, int at, int bt, int pt) {
        this.name = name;
        this.arrivalTime = at;
        this.burstTime = bt;
        this.priority = pt;
        this.completed = false;
    }
}

public class Solution {
    public static double averageWaitingTime(List<Process> processList, int n) {
        int currentTime = 0, completed = 0, totalWT = 0;

        while (completed < n) {
            Process next = null;
            int highestPriority = Integer.MAX_VALUE;

            for (Process p : processList) {
                if (!p.completed && p.arrivalTime <= currentTime && p.priority < highestPriority) {
                    highestPriority = p.priority;
                    next = p;
                }
            }

            if (next == null) {
                currentTime++;
            } else {
                currentTime += next.burstTime;
                next.completionTime = currentTime;
                next.completed = true;
                completed++;
            }
        }

        for (Process p : processList) {
            int tat = p.completionTime - p.arrivalTime;
            int wt = tat - p.burstTime;
            totalWT += wt;
        }

        return (double) totalWT / n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Process> processList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = "P" + (i + 1);
            int at = sc.nextInt();
            int bt = sc.nextInt();
            int pt = sc.nextInt();
            processList.add(new Process(name, at, bt, pt));
        }

        double ans = averageWaitingTime(processList, n);
        System.out.printf("%.2f", ans);
    }
}
//Time Complexity: O(n^2) in the worst case, where n is the number of processes.
//Space Complexity: O(n) for storing the process list.