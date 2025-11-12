// 04
package th.ac.kmutt.cpe.algorithm.pawarisa.old;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSelect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int k = sc.nextInt();
        int l = 0;
        int r = n-1;
        Algo algo = new Algo();
        System.out.println(list);
        System.out.println(algo.quickSelect(list, l, r, k));

        sc.close();
    }
}
