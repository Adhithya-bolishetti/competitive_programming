import java.util.*;

class Data {
    int start;
    int end;
    int pos;

    public Data(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class itemComparator implements Comparator<Data> {
    @Override
    public int compare(Data d1, Data d2) {
        if(d1.end < d2.end) return -1;
        else if (d1.end > d2.end) return 1;
        else return 0;
    }
}
class NmeetingsinOneRoom {

    // Comparator to sort by end time

    public static int Nmeetings(int[] start_arr, int[] end_arr, int n) {
        Data[] arr = new Data[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Data(start_arr[i], end_arr[i], i + 1);
        }

        Arrays.sort(arr, new itemComparator());

        int count = 1;
        int freetime = arr[0].end;

        for (int i = 1; i < n; i++) {
            if (arr[i].start > freetime) {
                count++;
                freetime = arr[i].end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start_arr = new int[n];
        for (int i = 0; i < n; i++) {
            start_arr[i] = sc.nextInt();
        }
        int[] end_arr = new int[n];
        for (int i = 0; i < n; i++) {
            end_arr[i] = sc.nextInt();
        }
        int ans = Nmeetings(start_arr, end_arr, n);
        System.out.println("No. of meetings : " + ans);
    }
}
// Time Complexity: O(nlogn) for sorting the meetings
// Space Complexity: O(n) for storing the meetings