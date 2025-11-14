package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.ArrayList;
import java.util.Scanner;

public class HistogramSelect {
    public static double select(ArrayList<Double> D, int k, int b) {
        ArrayList<Double> temp = new ArrayList<>(D);
        
        while(true) {
            double mn = Double.MAX_VALUE;
            double mx = Double.MIN_VALUE;
 
            for (int i = 0; i < temp.size(); i++) {
                mn = Math.min(temp.get(i), mn);
                mx = Math.max(temp.get(i), mx);
            }
            if (mn == mx) {
                return mn;
            }

            double width = (mx - mn) / b;
            ArrayList<ArrayList<Double>> bins= new ArrayList<>();
            int[] binCounts = new int[b];
            for (int i = 0; i < b; i++) {
                bins.add(new ArrayList<>());
            }

            for (double val : temp) {
                int binIndex = (int) ((val - mn) / width);
                if (binIndex == b) {
                    binIndex = b - 1;
                }
                bins.get(binIndex).add(val);
                binCounts[binIndex]++;
            }

            int nextR;
            for (nextR = 0; nextR < bins.size(); nextR++) {
                int binSize = binCounts[nextR];
                if (k > binSize) {
                    k -= binSize;
                } else {
                    break;
                }
            }

            temp = new ArrayList<>(bins.get(nextR));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextDouble());
        }
        int k = sc.nextInt();
        
        double result = select(list, k, b);
        System.out.printf("%.2f\n", result);
        sc.close();
    }
}