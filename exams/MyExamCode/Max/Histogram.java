package Max;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Histogram h = new Histogram();
        ArrayList<Double> d = new ArrayList<>();

        int n = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 0; i < n; i++) {
            d.add(sc.nextDouble());
        }
        int k = sc.nextInt();

        System.out.println(h.select(d, b, k));
        sc.close();
    }

    private double select(ArrayList<Double> d, int b, int k) {
        if (d.size() == 1) return d.get(0);

        double mx = Collections.max(d);
        double mn = Collections.min(d);
        if (mx == mn) return mn;
        double w = (mx - mn) / b;

        int[] count = new int[b];
        for (double v : d) {
            int index = Math.min((int) ((v - mn) / w), b - 1);
            count[index]++;
        }

        int cum = 0, bin = -1;
        for (int i = 0; i < b; i++) {
            if (cum + count[i] >= k) {
                bin = i;
                break;
            }
            cum += count[i];
        }
        if (bin == -1) return mx;

        double start = mn + bin * w, end = start + w;
        ArrayList<Double> sel = new ArrayList<>();
        for (double v : d) {
            if ((v >= start && v < end) || (bin == b - 1 && v == mx)) {
                sel.add(v);
            }
        }

        return sel.size() == 1 ? sel.get(0) : select(sel, b, k - cum);
    }
}
