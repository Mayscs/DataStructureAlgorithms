package Stack;

public interface Stack<T> {
	void push(T value);
	T pop();
	T peek();
	int getSize();
}
