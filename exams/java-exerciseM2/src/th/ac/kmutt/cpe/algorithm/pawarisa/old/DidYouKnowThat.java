package th.ac.kmutt.cpe.algorithm.pawarisa.old;

import java.util.*;

public class DidYouKnowThat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        
        Algo algo = new Algo();
        int[] answerList = algo.nextPermutation(A, n);

        sc.close();

        // sc.next();
        
        // char[] A = new char[n];
        // for (int i = 0; i < n; i++) {
        //     A[i] = sc.next().charAt(0); // sc.next is long text. so .charAt(0) means get first char of that strings
        // }
        // System.out.println(Arrays.toString(A));
    }
}
