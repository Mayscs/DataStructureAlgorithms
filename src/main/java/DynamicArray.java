import java.util.Iterator;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

@Getter
public class DynamicArray<T> implements Iterable<T> {

	private T[] array ;
	private int length;
	private int capacity;
	private int index=0;

	public DynamicArray(int initCapacity){
		if (initCapacity < 0)throw new IllegalArgumentException("Capacity should be greator than or equal to 0, value provided :" + initCapacity + " is not accepted.");
		array = (T[]) new Object[initCapacity];
		this.length = this.capacity = initCapacity;
	}

	public DynamicArray(){
		this(8);
	}

	public void add(T value){
		if (capacity > index) {
			array[index] = value;
			index++; capacity--;
		} else {
			T[] newArray = (T[]) new Object[length*2];
			for(i=0;i<array.length;i++){
				newArray[i]=array[i];
			}
			array=newArray;
		}
	}

	public void remove(T value){
	int index = indexOf(value);
	if (index == -1) throw new ValueException("Value not found");
	else remove(index);
	}

	private int indexOf(T value) {
		for(int i=0; i < length; i++) {
			if (array[i] == value)
				return i;
		}
		return -1;
	}

	public void remove(int rmIndex){
		if(rmIndex < 0 && rmIndex >=length) throw new IndexOutOfBoundsException("Remove Index out of size of array.");
		if (rmIndex == length-1) array[rmIndex]=null;
		for(int i=rmIndex; i<length-1; i++){ ;
			array[i]=array[i+1];
		}
	}

	public Iterator<T> iterator() {
		return null;
	}
}
