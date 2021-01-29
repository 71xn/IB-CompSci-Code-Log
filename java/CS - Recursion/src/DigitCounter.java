import java.util.Scanner;

public class DigitCounter {
	
	public int counter;

	public int numberofDigits(int n) {
		int n1 = n / 10;
		counter++;
		if (n1 == 0) {
			int c = counter;
			counter = 0;
			return c;
		} else {
			return numberofDigits(n1);
		}
	}
	
	public DigitCounter() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input a number for the digits to be counted: ");
		int n = scanner.nextInt();
		System.out.println("Digits: " + numberofDigits(n));
		scanner.close();
	} 
	
	public static void main(String[] args) {
		new DigitCounter();
	}
}
