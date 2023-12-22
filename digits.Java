import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int posint = 0;

        // Loop until a valid number is entered
        while (posint < 1000 || posint > 9999) {
            System.out.println("Please enter a positive, 4-digit number (1000 to 9999):");
            posint = input.nextInt();

            // Check if the number is not a 4-digit number
            if (posint < 1000 || posint > 9999) {
                System.out.println("Invalid input. Please enter a 4-digit number.");
            }
        }

        // If we're here, posint is a valid 4-digit number
        int thousands = posint / 1000; // Extracting thousands digit
        int hundreds = posint % 1000 / 100; // Extracting hundreds digit
        int tens = posint % 100 / 10; // Extracting tens digit
        int ones = posint % 10; // Extracting ones digit

        System.out.println("The digits of " + posint + " are " + thousands + ", " 
                           + hundreds + ", " + tens + ", and " + ones + ".");
    }
}
