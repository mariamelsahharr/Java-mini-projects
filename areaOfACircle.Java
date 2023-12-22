import java.util.Scanner;

public class AreaOfACircle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the radius: ");
        double radius = input.nextDouble();
 
        final double PI = Math.PI; //accurate value of PI
        double area = PI * radius * radius; // Area calculation
        double circumference = 2 * PI * radius; // Circumference calculation

        System.out.println("Area = " + area + " units^2");
        System.out.println("Circumference = " + circumference + " units");
    }
}
