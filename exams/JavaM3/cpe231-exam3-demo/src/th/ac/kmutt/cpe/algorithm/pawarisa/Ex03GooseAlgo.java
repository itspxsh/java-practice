package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.ArrayList;

public class Ex03GooseAlgo {
    public static void Grilled(int x, int n, ArrayList<Integer> list) {
        boolean possible[] = new boolean[x+1];
        possible[0] = true;
        int max = 0;
        for (int i = 0; i < possible.length; i++){
            if (possible[i]) {
                for (int j = 0; j < n; j++) {
                    if ((list.get(j) + i) <= x) {
                        possible[list.get(j) + i] = true;
                    }
                }
            } else {
                max = i;
            }
        }
        System.out.println(max);
    }
}
