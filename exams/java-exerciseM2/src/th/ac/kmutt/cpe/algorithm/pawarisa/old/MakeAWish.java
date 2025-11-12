package th.ac.kmutt.cpe.algorithm.pawarisa.old;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeAWish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Algorithms<Integer> maxsum = new Algorithms<>();
        System.out.println(maxsum.maxSubarraySum(list));
        sc.close();
    }
}