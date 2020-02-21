package Arrays;

public interface DynamicArray<T> {
	void add(T value);
	void remove(T value);
	T remove(int Index);
	void update(int index, T value);
	void display();

	int getLength();
}
