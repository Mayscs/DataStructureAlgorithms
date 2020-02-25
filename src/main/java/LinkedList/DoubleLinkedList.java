package LinkedList;

public interface DoubleLinkedList<T> {
	void addAtHead(T data);
	void remove(T data) throws Exception;
	void makeCircular();
	void display();
	boolean hasElement(T data) throws Exception;
	int getLength();
}
