package th.ac.kmutt.cpe.algorithm.pawarisa.knew;

import java.util.Arrays;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.pawarisa.CheatSheet01;

public class MakeAWish {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        CheatSheet01 cs = new CheatSheet01();
        System.out.println(cs.kadanne(A));
        // System.out.println(Arrays.toString(A));
        sc.close();
    }
}
