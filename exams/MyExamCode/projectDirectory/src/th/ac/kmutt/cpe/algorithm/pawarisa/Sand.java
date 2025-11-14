package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.ArrayList;
import java.util.Scanner;

public class Sand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Long> piles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            piles.add(sc.nextLong());
        }

        long totalCost = 0;

        while (piles.size() > 1) {
            long min1_val = Long.MAX_VALUE;
            int min1_idx = -1;

            for (int i = 0; i < piles.size(); i++) {
                if (piles.get(i) < min1_val) {
                    min1_val = piles.get(i);
                    min1_idx = i;
                }
            }

            piles.remove(min1_idx);

            long min2_val = Long.MAX_VALUE;
            int min2_idx = -1;

            for (int i = 0; i < piles.size(); i++) {
                if (piles.get(i) < min2_val) {
                    min2_val = piles.get(i);
                    min2_idx = i;
                }
            }

            piles.remove(min2_idx);

            long newPileCost = min1_val + min2_val;
            totalCost += newPileCost;

            piles.add(newPileCost);
        }

        System.out.println(totalCost);
        sc.close();
    }
}