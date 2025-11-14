package T;

import java.util.ArrayList;
import java.util.Scanner;

public class HistogramSelect {

    public static double select(ArrayList<Double> D, int k, int b) {
        ArrayList<Double> temp = new ArrayList<>(D);
        
        while (true) {
            double mn = Double.MAX_VALUE;
            double mx = Double.MIN_VALUE;
            for (int i = 0; i < temp.size(); i++) {
                mn = Math.min(temp.get(i), mn);
                mx = Math.max(temp.get(i), mx);
            }

            // --- FIX #1: Added base case to prevent infinite loop ---
            if (mn == mx) {
                return mn;
            }

            double width = (mx - mn) / b;

            // --- FIX #2: Replaced complex binning with the simple, easy logic ---
            // (This logic is from Code #2 and is much easier to remember)
            
            ArrayList<ArrayList<Double>> bins = new ArrayList<>();
            int[] binCounts = new int[b]; // <-- Need counts for the next step
            for (int i = 0; i < b; i++) {
                bins.add(new ArrayList<>());
            }
            
            for (double val : temp) { // <-- Simpler loop
                int binIndex = (int) ((val - mn) / width);
                if (binIndex == b) { // <-- The easy-to-remember edge case
                    binIndex = b - 1;
                }
                bins.get(binIndex).add(val); // <-- Add value to the correct bin
                binCounts[binIndex]++;      // <-- Increment the count
            }
            // --- End of FIX #2 ---


            // This "find target bin" loop is correct, but let's use binCounts
            int nextR;
            for (nextR = 0; nextR < bins.size(); nextR++) {
                int binSize = binCounts[nextR]; // <-- Use the counts
                if (k > binSize) {
                    k -= binSize;
                } else {
                    break;
                }
            }

            // --- FIX #3: Simplified the "next step" ---
            // The `if(nextBin.size() == 1)` check is no longer needed
            // because our `if (mn == mx)` base case at the top will
            // handle it on the next loop.
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

        // --- FIX #4: Removed debug/extra print line ---
        // System.out.println(list.get(k-1)); 

        // --- FIX #5: Format output to match Code #2 ---
        double result = select(list, k, b);
        System.out.printf("%.2f\n", result); // <-- Use printf for 2 decimal places

        sc.close();
    }
}