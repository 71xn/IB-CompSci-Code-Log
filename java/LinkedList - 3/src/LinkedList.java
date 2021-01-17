import java.util.Iterator;

public class LinkedList<O> implements Iterable<O> {

	class Node {

		private O d;
		Node next;
		Node prev;

		public Node(O d) {
			this.d = d;
			next = null;
			prev = null;
		}

		
		@Override
		public String toString() {
			return String.valueOf(d);
		}

	}

	protected Node head;
	protected Node tail;
	private int size = 0;

	public LinkedList() {
		head = null;
		tail = null;
	}

	public boolean isOmpty() {
		return head == null;
	}
	
	public int size() {
		return size;
	}

	public void add(O d) {
		Node newNode = new Node(d);
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		newNode.next = null;
		Node tailNode = tail;
		tailNode.next = newNode;
		tail = newNode;
		size++;
		
	}

	public void addFirst(O d) {
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
		size++;
	}

	public String peek() {
		return head.toString();
	}

	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void remove() {
		Node newHead = head.next;
		head = newHead;
		size--;
	}

	public void remove(int index) {
		Node current = head;
		// Debug lines
		//System.out.println(current);
		//System.out.println(head.next);
		if (index == 0) {
			head = current.next;
			//System.out.println(current.next);
			size--;
			return;
		}
		
		for (int i = 0; head != null && i < (index - 2); i++) {
			current = current.next;
		}
		if (current == null || current.next == null) { // If item is not in list
			return;
		}
		// Debug line: System.out.println("Node containing data: " + current.next + " to be removed");
		Node toRemoveNext = current.next.next;
		Node toRemovePrev = current;
		toRemovePrev.next = toRemoveNext;
		size--;
	}
	
	public void insert(O d, int index) {
		Node current = head;
		Node newNode = new Node(d);
		if (index == 0) {
			newNode.next = current.next;
			newNode.prev = current;
			current.next = newNode;
			Node nextNode = current.next.next;
			nextNode.prev = newNode;
			return;
		}
		
		for (int i = 0; i < (index - 1); i++) {
			current = current.next;
		}
		
		if (current.next == null) {
			add(d);
			return;
		}
		
		newNode.next = current.next;
		newNode.prev = current;
		current.next = newNode;
		Node nextNode = current.next.next;
		nextNode.prev = newNode;
	}
	
	@SuppressWarnings("unchecked")
	public O get(int index) {
		Node current = head;
		if (index == 0) {
			
			return (O) current.toString();
		}
		
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		
		return (O) current.toString();
	}
	
	 
	
	// Allows list iteration 
	
	private class ListIterator implements Iterator<O> {
		
		Node current = head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public O next() {
			// TODO Auto-generated method stub
			if (hasNext()) {
				O data = current.d;
				current = current.next;
				return data;
			} return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			System.out.println("Opperation not supported!");
		}
		
		
	}

	@Override
	public Iterator<O> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

}
