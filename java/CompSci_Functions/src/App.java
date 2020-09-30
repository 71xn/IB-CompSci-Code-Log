// Finn Lestrange - 30/09/2020
// Functions

import java.util.Scanner;

public class App {
    public static int findSum(int n1, int n2, int n3) {
        return (n1 + n2 + n3);
    }

    public static int factorial(int fact1) {
        int fact = 1;
        for (int i = 1; i <= fact1; i++) {
            fact = fact*i;
        }
        return fact;
    }

    public static int maxMin(int n1, int n2 , int n3) {
        int num = 0;
        if (n1 > n2 && n1 > n3) {
            num = n1;
        } else if (n2 > n1 && n2 > n3) {
            num = n2;
        } else {
            num = n3;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digit Sum: ");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        System.out.println(findSum(n1, n2, n3));

        System.out.print("Factorial of: ");
        int fact1 = scanner.nextInt();
        System.out.println(factorial(fact1));

        System.out.println("Largest of three numbers: ");
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        n3 = scanner.nextInt();
        System.out.print(maxMin(n1, n2, n3));
    }
}
