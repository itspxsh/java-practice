package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.Scanner;

public class Zigzag {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] seq = new int[n];
        for (int i = 0; i < n; i++) seq[i] = sc.nextInt();

        // dpUp[i] = max zigzag ending at i with last move up
        // dpDown[i] = max zigzag ending at i with last move down
        int[] dpUp = new int[n];
        int[] dpDown = new int[n];

        for (int i = 0; i < n; i++) {
            dpUp[i] = dpDown[i] = 1; // every element is a base case
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j]) {
                    dpUp[i] = Math.max(dpUp[i], dpDown[j] + 1);
                } else if (seq[i] < seq[j]) {
                    dpDown[i] = Math.max(dpDown[i], dpUp[j] + 1);
                }
            }
        }

        // print DP( , TRUE)
        for (int i = 0; i < n; i++) {
            System.out.print(dpUp[i]);
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println();

        // print DP( , FALSE)
        for (int i = 0; i < n; i++) {
            System.out.print(dpDown[i]);
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println();

        sc.close();
    }
}
