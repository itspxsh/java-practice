package th.ac.kmutt.cpe.algorithm.pawarisa.old;

import java.util.*;

public class QuickSortTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = 0;
        int r = n-1;
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        Algo algo = new Algo();
        algo.quickSort(A, l, r);

        // for (int element : A) {
        //     System.out.printf("%d ", element);
        // }
        System.out.println(Arrays.toString(A));
        sc.close();
    }
}
