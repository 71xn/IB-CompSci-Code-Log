import java.util.Random;
import java.util.Scanner;

public class Activity {
	public static int front = -1;
	public static int rear = -1;
	public static int max = 7;
	public static String[] queue = new String[8];
	public static Scanner scanner = new Scanner(System.in);
	public static Random rand = new Random();
	
	public static boolean avaliable = true;
	
	private static void enqueue(String x) {
		if (((rear + 1) == front) || (front == 0 && rear == (max-1))) {
			System.out.println("Queue Overflow!");
			avaliable = false;
		} 
		
		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (rear == (max - 1)) {
			rear = 0;
		} else {
			rear = rear + 1;
		}
		//System.out.println(avaliable); // Debug line
		if (avaliable) {
			queue[rear] = x;
		}
	}
	
	private static void dequeue() {
		System.out.print(queue[front]);
		if (front == -1) {
			System.out.println("Queue Underflow!");
		} 
		
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == (max - 1)) {
			front = 0;
		} else {
			front++;
		}
		
		
	}
	
	private static void display() {
		int frontpos  = front;
		int rearpos = rear;
		if (front == -1) {
			System.out.println("Queue Empty!");
		} else if (frontpos <= rearpos) {
			for (int i = frontpos; i <= rearpos; i++) {
				System.out.print(queue[i] + ", ");
			}
		} else {
			for (int i = frontpos; i <= (max - 1); i++) {
				System.out.print(queue[i] + ", ");
			}
			frontpos = 0;
			for (int i = frontpos; i <= rearpos; i++) {
				System.out.print(queue[i] + ", ");
			}
		}
	}
	
	private static void question() {
		System.out.println("Do you have a question about a Current account or a Savings Account: Please Enter C or S: ");
		String input = scanner.next();
		if (input.equals("C")) {
			String token = "C-" + Integer.toString(rand.nextInt(200));
			enqueue(token);
		} else if (input.equals("S")) {
			String token = "S-" + Integer.toString(rand.nextInt(200));
			enqueue(token);
		} else {
			System.out.println("Incorrent Input");
		}
	}

	private static void teller() {
		System.out.println("");
		System.out.print("Can customer: ");
		dequeue();
		System.out.print(", Please come to the teller counter.");
		System.out.println();
		System.out.print("Next customers: ");
		display();
	}
	
	public static void main(String[] args) {
		int i = 4;
		int count = 0;
		while (count < i) {
			count++;
			question();	
		}
		
		int c = 0;
		while (c < (i-2)) {
			teller();
			c++;
		}
		
	}
	
	
}
