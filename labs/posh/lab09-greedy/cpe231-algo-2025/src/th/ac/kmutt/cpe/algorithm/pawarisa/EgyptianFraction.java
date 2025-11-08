package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.Scanner;

public class EgyptianFraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input numerator then denominato:");

        int numerator = sc.nextInt();
        int denominator = sc.nextInt();

        System.out.print(numerator+ "/" + denominator + " = ");
        Algo.toEgyptian(numerator, denominator); 
        sc.close();
    }
}
