package th.ac.kmutt.cpe.algorithm.pawarisa.old;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.set(i, sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(n);
        System.out.println(A);
        System.out.println(k);
        sc.close();
    }
}
