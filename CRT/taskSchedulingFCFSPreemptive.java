import java.util.*;

class Process {
    String name;
    int arrivalTime, burstTime, remainingTime, completionTime;

    Process(String name, int at, int bt) {
        this.name = name;
        this.arrivalTime = at;
        this.burstTime = bt;
        this.remainingTime = bt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Process> processList = new ArrayList<>();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter arrival time for P" + i + ": ");
            int at = sc.nextInt();
            System.out.print("Enter burst time for P" + i + ": ");
            int bt = sc.nextInt();
            processList.add(new Process("P" + i, at, bt));
        }

        System.out.print("Enter time quantum: ");
        int quantum = sc.nextInt();

        Queue<Process> queue = new LinkedList<>();
        int currentTime = 0;
        int completed = 0;
        boolean[] isInQueue = new boolean[n];

        // Sort by arrival time initially
        processList.sort(Comparator.comparingInt(p -> p.arrivalTime));

        queue.add(processList.get(0));
        isInQueue[0] = true;

        while (completed < n) {
            if (queue.isEmpty()) {
                currentTime++;
                // Check for next arriving process
                for (int i = 0; i < n; i++) {
                    Process p = processList.get(i);
                    if (!isInQueue[i] && p.arrivalTime <= currentTime && p.remainingTime > 0) {
                        queue.add(p);
                        isInQueue[i] = true;
                    }
                }
                continue;
            }

            Process current = queue.poll();

            int execTime = Math.min(quantum, current.remainingTime);
            System.out.println(current.name + " executes from " + currentTime + " to " + (currentTime + execTime));
            currentTime += execTime;
            current.remainingTime -= execTime;

            // Enqueue newly arrived processes
            for (int i = 0; i < n; i++) {
                Process p = processList.get(i);
                if (!isInQueue[i]  && p.remainingTime > 0) {
                    queue.add(p);
                    isInQueue[i] = true;
                }
            }

            if (current.remainingTime > 0) {
                queue.add(current); // Add back to queue
            } else {
                current.completionTime = currentTime;
                completed++;
            }
        }

        // Print results
        System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
        int totalWT = 0;
        for (Process p : processList) {
            int tat = p.completionTime - p.arrivalTime;
            int wt = tat - p.burstTime;
            totalWT += wt;
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\n", p.name, p.arrivalTime, p.burstTime, p.completionTime, tat, wt);
        }
        
        double avgWT = (double) totalWT / n;
        System.out.printf("\nAverage Waiting Time: %.2f\n", avgWT);

    }
}
// Time complexity : O(Total burst time * n)
// Space complexity : O(n)