package LinkedList;

public interface DoubleLinkedList<T> {
	void addAtHead(T data);
	void remove(T data) throws Exception;
	void display();
	void hasElement(T data);
	int getLength();
}
