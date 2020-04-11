package LinkedList;

import java.util.Iterator;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

class Node<T> {
	Node next;
	Node prev;
	T data;

	public Node(T data) {
		this.next = null;
		this.prev = null;
		this.data = data;
	}
}

public class DoubleLinkedListImpl<T> implements DoubleLinkedList<T>, Iterable<T> {
	private Node head;
	private int length ;

	public DoubleLinkedListImpl() {
		this.length = 0;
		this.head = null;
	}

	@Override
	public void addAtHead(T data) {
		Node newNode = new Node(data);
		if (isEmpty()) head=newNode;
		else {
			head.prev = newNode;
			newNode.next = head;
			head=newNode;
		}
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
		while (seek!=null && seek.data != data) {
			seek = seek.next;
		}
		if (seek == null){
			throw new ValueException("data not present");
		} else {
			temp = seek;
			if (seek.prev != null)
				seek.prev.next = seek.next;
			if (seek.next != null)
				seek.next.prev = seek.prev;
			seek.prev=seek.next = null;
			seek.data = null;
			length--;
		}
	}

	@Override
	public void display() {
		if (isEmpty()) {
			System.out.println("[]");
			return;
		}
		Node seek = head;
		System.out.print("[ ");
		while(seek != null && seek.next != head) {
			System.out.print(seek.data + "<->");
			seek=seek.next;
		}
		if (seek != null && seek.next == head){
			System.out.print(seek.data + "<->" + head.data);
		}
		System.out.print(" ]");
	}

	@Override
	public void makeCircular() {
		if (isEmpty())return;
		System.out.println("/\n Hurray!! I am now Circular List, I have no hanging ends.");
		Node tail = head;
		while(tail.next!=null)tail=tail.next;
		tail.next=head;
		head.prev=tail;
	}

	@Override
	public boolean hasElement(T data) throws Exception {
		if (isEmpty()) throw new Exception("List is empty");
		Node seek = head;
		while (seek.next!=null || seek.data == data) {seek=seek.next;}
		return (seek.data == data)?true:false;
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
