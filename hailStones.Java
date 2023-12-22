package com.company;

import java.util.Scanner;

public class HailStones {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Who is user 1?");
        String us1 = inputScanner.nextLine();

        System.out.println("Who is user 2?");
        String us2 = inputScanner.nextLine();

        boolean ans;
        int points1 = 0;
        int points2 = 0;

        do {
            int steps = 0;
            int steps2 = 0;
            int highnumb1 = 0;
            int highnumb2 = 0;

            int number = getValidNumber(inputScanner, us1);
            int number2 = getValidNumber(inputScanner, us2);

            // Sequence for User 1
            System.out.println("This is the sequence for: " + us1);
            highnumb1 = printSequence(number);
            steps = getSteps(number);

            // Sequence for User 2
            System.out.println("*********\n\nThis is the sequence for: " + us2);
            highnumb2 = printSequence(number2);
            steps2 = getSteps(number2);

            // Points Calculation
            updatePoints(steps, steps2, highnumb1, highnumb2, points1, points2, us1, us2);

            // Play again prompt
            ans = getPlayAgainResponse(inputScanner);

        } while (ans);

        System.out.println("Goodbye!");
    }

    private static int getValidNumber(Scanner inputScanner, String user) {
        int number;
        do {
            System.out.print("Ok, " + user + ", Enter a Number (between 1 and 100): ");
            number = inputScanner.nextInt();
            if (number <= 0 || number > 100) {
                System.out.println(user + ", you entered an invalid number. Try again.");
            }
        } while (number <= 0 || number > 100);
        return number;
    }

    private static int printSequence(int number) {
        int highnumb = 0;
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            System.out.print(number + ", ");
            highnumb = Math.max(number, highnumb);
        }
        System.out.println();
        return highnumb;
    }

    private static int getSteps(int number) {
        int steps = 0;
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            steps++;
        }
        return steps;
    }

    private static void updatePoints(int steps, int steps2, int highnumb1, int highnumb2, int points1, int points2, String us1, String us2) {
        if (steps > steps2) {
            points1 += steps - steps2;
        } else if (steps2 > steps) {
            points2 += steps2 - steps;
        }

        if (highnumb1 > highnumb2) {
            points1 += 5;
        } else if (highnumb2 > highnumb1) {
            points2 += 5;
        }

        // Display current points
        if (points1 > points2) {
            System.out.println(us1 + " is currently in the lead with " + points1 + " points.");
        } else if (points2 > points1) {
            System.out.println(us2 + " is currently in the lead with " + points2 + " points.");
        } else {
            System.out.println(us1 + " and " + us2 + " are tied with " + points1 + " points each.");
        }
    }

    private static boolean getPlayAgainResponse(Scanner inputScanner) {
        System.out.println("Do you want to play again? (y/n)");
        String response = inputScanner.next().toLowerCase();
        return response.startsWith("y");
    }
}
