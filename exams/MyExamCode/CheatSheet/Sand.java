package CheatSheet;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * This version solves the Sand problem without any built-in sorting
 * or PriorityQueues.
 *
 * Algorithm (Easy to remember O(n^2) "find two mins" method):
 * 1. Read all numbers into an ArrayList.
 * 2. Keep a 'totalCost' (as a long).
 * 3. While the list has > 1 pile:
 * a. Find the index of the smallest pile ('min1_idx').
 * b. Remove it and store its value ('min1_val').
 * c. Find the index of the *new* smallest pile ('min2_idx').
 * d. Remove it and store its value ('min2_val').
 * e. Calculate cost = min1_val + min2_val.
 * f. Add 'cost' to 'totalCost'.
 * g. Add the new pile 'cost' back into the list.
 * 4. Print totalCost.
 */
public class Sand {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Use ArrayList because it's easy to remove items from
        ArrayList<Long> piles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            piles.add(sc.nextLong());
        }

        long totalCost = 0;

        // Loop until only one combined pile is left
        while (piles.size() > 1) {
            
            // --- Step 1: Find the smallest pile ---
            long min1_val = Long.MAX_VALUE;
            int min1_idx = -1;
            for (int i = 0; i < piles.size(); i++) {
                if (piles.get(i) < min1_val) {
                    min1_val = piles.get(i);
                    min1_idx = i;
                }
            }
            // Remove it. This .remove(index) is O(n), which is fine.
            piles.remove(min1_idx); 

            // --- Step 2: Find the *second* smallest pile ---
            // (which is now the smallest pile in the remaining list)
            long min2_val = Long.MAX_VALUE;
            int min2_idx = -1;
            for (int i = 0; i < piles.size(); i++) {
                if (piles.get(i) < min2_val) {
                    min2_val = piles.get(i);
                    min2_idx = i;
                }
            }
            // Remove it
            piles.remove(min2_idx);

            // --- Step 3: Combine and add cost ---
            long newPileCost = min1_val + min2_val;
            totalCost += newPileCost;

            // --- Step 4: Add the new pile back to the list ---
            piles.add(newPileCost);
        }

        System.out.println(totalCost);
        sc.close();
    }
}