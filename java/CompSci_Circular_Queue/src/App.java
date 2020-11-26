
public class App {
	public static int front = -1;
	public static int rear = -1;
	public static int max = 7;
	public static int[] queue = new int[7];
	
	public static boolean avaliable = true;
	
	private static void enqueue(int x) {
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
		
		if (avaliable) {
			queue[rear] = x;
		}
	}
	
	private static void dequeue() {
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
			for (int i = frontpos; i < rearpos; i++) {
				System.out.println(queue[i]);
			}
		} else {
			for (int i = frontpos; i < (max - 1); i++) {
				System.out.println(queue[i]);
			}
			frontpos = 0;
			for (int i = frontpos; i < rearpos; i++) {
				System.out.println(queue[i]);
			}
		}
	}
	
	
}
