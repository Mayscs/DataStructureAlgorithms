package LinkedList;

import java.util.Iterator;

public class DoubleLinkedListImpl<T> implements DoubleLinkedList<T>, Iterable<T> {
	public class Node {
		Node next;
		Node prev;
		T data;

		public Node(T data) {
			this.next = null;
			this.prev = null;
			this.data = data;
		}
	}

	private Node head;
	private int length ;

	public DoubleLinkedListImpl(Node node) {
		length = 0;
		head = null;
	}

	@Override
	public void addAtHead(T data) {
		Node newNode = new Node(data);
		if (!isEmpty()) head.prev = newNode;
		newNode.next = head;
		head = newNode;
		length++;
		}

	private boolean isEmpty() {
		return (length == 0);
	}

	@Override
	public void remove(T data) throws Exception {
		if (isEmpty()) throw new Exception("List is empty.");
		Node seek = head;
		Node temp;
		while (seek.data != data) {
			seek = seek.next;
		}
		if (seek != null) {
			temp = seek;
			if (seek.prev != null)
				seek.prev.next = seek.next;
			if (seek.next != null)
				seek.next.prev = seek.prev;
			seek.prev=seek.next = null;
			seek.data = null;
		}
	}

	@Override
	public void display() {
		Node seek = head;
		System.out.println("[");
		while(seek != null) {
			//this.toString();
			System.out.println(seek.data + ",");
		}
		System.out.println("]");
	}

	@Override
	public void hasElement(T data) {

	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}
}
