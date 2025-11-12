package th.ac.kmutt.cpe.algorithm.pawarisa.old;

import java.util.Arrays;
import java.util.Scanner;

public class Andriod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String [] strings = new String[m];
        /* [ABCEDGHIF, IHGFEDCBA, ABCDEFGHI] */ 

        for (int i = 0; i < m; i++) {
            strings[i] = sc.next();
        }

        

        // System.out.println(n);
        // System.out.println(m);
        // System.out.println(Arrays.toString(strings));
        sc.close();








        // Character[] currentPerm = new Character[n];

        // // Build the 1st pattern
        // for (int i = 0; i < n; i++) {
        //     currentPerm[i] = (char) ('A' + i);
        //     // ('A' + 0 = 'A'), ('A' + 1 = 'B'), ...
        // }

        // sc.next();
        // String[] targets = new String[m];
        // for (int i = 0; i < m; i++) {
        //     targets[i] = sc.nextLine();
        // }

        // System.out.println(targets);

        // int count = 1;
        // boolean found = false;
        // while (found == false) {
        //     // Turn char array to String
        //     String permString = "";
        //     for (int i = 0; i < currentPerm.length; i++) {
        //         Character c = currentPerm[i];
        //         permString += c;
        //     }
        //     for (int i = 0; i < m; i++) {
        //         if (permString.equals(targets[i])) {
        //             System.out.println(count);
        //             found = true;
        //         }
        //         // Begin finding pattern by pattern
        //         if (CheatSheet.nextPermutation(currentPerm)) {
        //                     found = true;
        //         }
        //         count++;
        //     }
        // }
    }
}
