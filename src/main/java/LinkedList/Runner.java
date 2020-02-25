package LinkedList;

public class Runner {
	public static void main(String[] args) {
		DoubleLinkedList<Integer> doublyLinkedList = new DoubleLinkedListImpl<>();
		doublyLinkedList.addAtHead(1);
		doublyLinkedList.addAtHead(2);
		doublyLinkedList.addAtHead(3);
		doublyLinkedList.addAtHead(4);
		doublyLinkedList.display();
		try {
			doublyLinkedList.remove(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		doublyLinkedList.makeCircular();
		doublyLinkedList.display();
	}
}
