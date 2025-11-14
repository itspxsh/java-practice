package CheatSheet;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * This solves the HistogramSelect problem using the required
 * recursive algorithm.
 *
 * It does NOT use Arrays.sort().
 * It includes its own private helper functions for findMin and findMax
 * to be self-contained and easy for an exam.
 */
public class HistogramSelect {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        ArrayList<Double> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(sc.nextDouble());
        }

        // k is 1-indexed (e.g., 71st smallest)
        int k = sc.nextInt();

        // Call the recursive helper function
        double result = findKthSmallest(data, b, k);

        // Print the final result formatted to 2 decimal places
        System.out.printf("%.2f\n", result);
        
        sc.close();
    }

    /**
     * Recursive function to find the k-th (1-indexed) smallest element.
     */
    /**
     * Recursive function to find the k-th (1-indexed) smallest element.
     * (Easier-to-remember version)
     */
    /**
     * Recursive function to find the k-th (1-indexed) smallest element.
     * (Easier-to-remember version)
     */
    private static double findKthSmallest(ArrayList<Double> data, int b, int k) {
        
        // --- BASE CASES ---
        if (data.size() == 1) {
            return data.get(0);
        }

        double min = findMin(data);
        double max = findMax(data);

        if (min == max) {
            return min;
        }

        // --- RECURSIVE STEP ---

        // Step 1: Calculate width
        double width = (max - min) / b;

        // Step 2: Count items in each bin (Same as before)
        int[] binCounts = new int[b];
        for (double val : data) {
            int binIndex = (int) ((val - min) / width);
            if (binIndex == b) { // Handle the edge case where val == max
                binIndex = b - 1; 
            }
            binCounts[binIndex]++;
        }

        // Step 3: Find the target bin (Same as before)
        int targetBin = -1;
        int cumulativeCount = 0; 
        for (int i = 0; i < b; i++) {
            if (cumulativeCount + binCounts[i] >= k) {
                targetBin = i;
                break;
            }
            cumulativeCount += binCounts[i];
        }

        // Step 4: Create new sub-list (This is now much simpler!)
        ArrayList<Double> subList = new ArrayList<>();
        for (double val : data) {
            // <-- CHANGED: Re-use the *exact* logic from Step 2
            int binIndex = (int) ((val - min) / width);
            if (binIndex == b) { // <-- CHANGED: Must include the edge case handle again
                binIndex = b - 1;
            }
            
            // <-- CHANGED: Just check if the bin index matches our target
            if (binIndex == targetBin) {
                subList.add(val);
            }
        }

        // Step 5: Update k for the new sub-list (Same as before)
        int newK = k - cumulativeCount;

        // Step 6: Recurse (Same as before)
        return findKthSmallest(subList, b, newK);
    }
    
    // --- HELPER FUNCTIONS (EASY TO REMEMBER) ---

    /**
     * Finds the minimum value in an ArrayList.
     */
    private static double findMin(ArrayList<Double> list) {
        double min = Double.POSITIVE_INFINITY;
        for (double v : list) {
            if (v < min) { // Corrected logic
                min = v;
            }
        }
        return min;
    }

    /**
     * Finds the maximum value in an ArrayList.
     */
    private static double findMax(ArrayList<Double> list) {
        double max = Double.NEGATIVE_INFINITY;
        for (double v : list) {
            if (v > max) { // Corrected logic
                max = v;
            }
        }
        return max;
    }
}