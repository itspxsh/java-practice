// 03
package th.ac.kmutt.cpe.algorithm.pawarisa.old;

import java.util.ArrayList;
import java.util.Scanner;

public class Pancake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(sc.nextInt());
            // System.out.println(list);
        }
        
        Algo algo = new Algo();
        algo.pancakeSort(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d ", numbers.get(i));
        }

        sc.close();
    }
}
