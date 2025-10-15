package basics;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println("Let's try user's input!");
        // Read input from stdin using the Scanner class and specifying the Input Stream as System.in.
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + ". Love u SU SU na <3");

        System.out.println("Practice Scanner class usage?");
        // class types (obj)
        String myString = sc.nextLine();
        // primitive types
        int myInt = sc.nextInt();
        double myDouble = sc.nextDouble();
        float myFloat = sc.nextFloat();
        // double is a primitive type for decimal numbers. Double is a class that wraps a double.

        System.out.println(myString + myInt + myDouble + myFloat);
    }
}