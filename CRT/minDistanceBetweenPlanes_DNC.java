import java.io.*;
import java.util.*;

class Plane {
    int x;
    int y;
    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {

    public static double distance(Plane a, Plane b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }

    public static double findMinStripDist(List<Plane> strip, double d) {
        double min = d;
        strip.sort(Comparator.comparingInt(p -> p.y));
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < min; j++) {
                min = Math.min(min, distance(strip.get(i), strip.get(j)));
            }
        }
        return min;
    }

    public static double closestPair(Plane[] points, int low, int high) {
        if (high - low <= 3) {
            double min = Double.MAX_VALUE;
            for (int i = low; i <= high; i++) {
                for (int j = i + 1; j <= high; j++) {
                    min = Math.min(min, distance(points[i], points[j]));
                }
            }
            Arrays.sort(points, low, high + 1, Comparator.comparingInt(p -> p.y)); 
            return min;
        }

        int mid = (low + high) / 2;
        Plane midPoint = points[mid];

        double dl = closestPair(points, low, mid);
        double dr = closestPair(points, mid + 1, high);
        double d = Math.min(dl, dr);

        Plane[] temp = new Plane[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (points[i].y < points[j].y)
                temp[k++] = points[i++];
            else
                temp[k++] = points[j++];
        }
        while (i <= mid) temp[k++] = points[i++];
        while (j <= high) temp[k++] = points[j++];
        System.arraycopy(temp, 0, points, low, temp.length);

        List<Plane> strip = new ArrayList<>();
        for (int m = low; m <= high; m++) {
            if (Math.abs(points[m].x - midPoint.x) < d) {
                strip.add(points[m]);
            }
        }

        return Math.min(d, findMinStripDist(strip, d));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Plane[] planes = new Plane[n];
        for (int i = 0; i < n; i++) {
            planes[i] = new Plane(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(planes, Comparator.comparingInt(p -> p.x)); 
        double ans = closestPair(planes, 0, n - 1);
        System.out.printf("%.6f\n", ans);
    }
}
