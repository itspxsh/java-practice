/**
    * Problem: Basic Calculator
    * Source: geeksforgeeks
    * Difficulty: Easy
    * Link: https://www.geeksforgeeks.org/java/basic-calculator-program-using-java/
    * * Description:
    * Create a simple calculator which can perform basic arithmetic operations like addition, subtraction, multiplication, or division depending upon the user input.
    */
package basics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // MODIFICATION: Start an infinite loop to keep the program running until a valid calculation is done.
        while (true) {
            try {
                System.out.println("Enter the first number: ");
                double x = sc.nextDouble();

                System.out.println("Enter the second number: ");
                double y = sc.nextDouble();

                System.out.println("Enter the Operator (+,-,*,/):");
                String operator = sc.next(); // FIX: Use sc.next() instead of sc.nextLine() since \n is already sitting in the buffer from the previous line.
                double ans = 0;
                boolean validOperation = true; // A flag to check if we should break the loop

                // FIX: 'switch' keyword must be lowercase
                // Operator is a String, so use double quotes for case labels
                switch (operator) {
                    case "+":
                        ans = x + y;
                        break;

                    case "-":
                        ans = x - y;
                        break;
                        
                    case "*":
                        ans = x * y;
                        break;
                        
                    case "/":
                        if (y == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false; // MODIFICATION: Set flag to false instead of exiting

                        } else ans = x / y;
                        break;

                    default :
                        System.out.println("Wrong input bro. The operator must be one of: +,-,*,/\"");  
                        validOperation = false; // MODIFICATION: Set flag to false instead of exiting        
                }

                if (validOperation) {
                    System.out.println("\nThe final result: ");
                    System.out.println(x + " " + operator + " " + y + " " + "=" + " " + ans);
                    break; // FIX: This exits the 'while' loop after a successful calculation.
                }
            } catch (InputMismatchException e) {
                // MODIFICATION: Catch the error if the user enters non-numeric input
                System.out.println("Invalid input. Please enter numbers only. Let's start over.");
                sc.next(); // Important: Clear the invalid input from the scanner
            }
        }
        sc.close();
    }
}