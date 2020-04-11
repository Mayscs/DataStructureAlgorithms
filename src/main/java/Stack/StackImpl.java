package Stack;

import java.util.EmptyStackException;

public class StackImpl<T> implements Stack<T>{

	private SingleLinkedList list;
	private int size;
	Node temp;

	private class Node<T> {
		private T value;
		private Node next;


		public Node(T value) {
			this.value=value;
			this.next=null;
		}
	}

	private class SingleLinkedList<T> {
		Node head;

		public SingleLinkedList() {
			this.head=null;
		}

		public void add(Node node) {
			node.next=head;
			head=node;
		}
	}

	public StackImpl() {
		this.list = new SingleLinkedList();
		this.size=0;
	}

	@Override
	public void push(T value) {
		list.add(new Node(value));
		size++;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		temp = list.head;
		list.head = list.head.next;
		size--;
		return (T) temp.value;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return (T) list.head.value;
	}

	private boolean isEmpty() {
		return ( size == 0 );
	}

	@Override
	public String toString() {
		if (list.head==null) {return "[ ]";}
/*		temp=list.head.next;
		String result= list.head.value.toString();
		while(temp != null) {
			result += "->" + temp.value;
			temp=temp.next;
		}
		return String.format("[ %s ]", result);*/
	StringBuilder sb = new StringBuilder().append("[");
	temp=list.head;
	while (temp != null) {
		sb.append(temp.value + "->");
		temp=temp.next;
	}
	return sb.replace(sb.length()-2, sb.length(),"]").toString();
	}

	@Override
	public int getSize(){
		return size;
	}
}
