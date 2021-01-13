
// Singly LinkedList Implementation 

public class LinkedList {
	
	Node head; // Head of the list, each list created has a head node
	
	static class Node {
		// Node needs a toString override so we can call sysout on it below
		@Override
		public String toString() {
			return "Node [d=" + d + "]";
		}

		int d; // Holds the data of the current node object
		Node next; // Holds the pointer to the next node in the list, or null
		
		Node(int d) {
			// When a node is created it's data it set to what the user defines and then the pointer is set to null
			this.d = d;
			this.next = null;
		}
	}
	
	public static LinkedList insert(LinkedList list, int d) {
		Node newNode = new Node(d); // Creates a new node and sets its data to d and next to null because of our Node constructor
		
		if (list.head == null) { // If the list is empty
			list.head = newNode; // New node is the head 
		} else { // Otherwise the new node is added to the list and the lastNode in the list now points to the new node
			Node lastNode = list.head;
			while(lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode; // Changes the lastNode from pointing to null, to pointing to the newNode
		}
		
		return list;
		
	}
	
	public static void print(LinkedList list) {
		Node lastNode = list.head;
		while (lastNode.next != null) {
			System.out.println(lastNode.toString());
			lastNode = lastNode.next;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		LinkedList.insert(list, 10);
		LinkedList.insert(list, 11);
		LinkedList.insert(list, 12);
		LinkedList.insert(list, 13);
		
		LinkedList.print(list);
		
	}
	
}
