package th.ac.kmutt.cpe.algorithm.pawarisa.knew;

import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.pawarisa.CheatSheet01;

public class Andriod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWSYZ";

        int n = sc.nextInt();
        int m = sc.nextInt();

        String first = alphabet.substring(0,n);
        // System.out.println(str);

        String[] targets = new String[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.next();
            // System.out.println(targets[i]);
        }

        for (int i = 0; i < m; i++) {
            String currentTarget = targets[i];

            int count = 1;
            // Turn first (String) into char so we can nextpermute them
            Character[] currentPerm = new Character[n];
            for (int j = 0; j < n; j++) {
                currentPerm[j] = first.charAt(j);
            }

            while(true) {
                // turn currentPerm into String to compare
                String permString = "";
                for (Character c : currentPerm) {
                    permString += c;
                }

                if (permString.equals(currentTarget)) {
                    System.out.println(count);
                    break;
                }

                CheatSheet01.nextPermutation(currentPerm);
                count++;
            }
        }
        sc.close();
    }
}
