package Arrays;

import java.util.Iterator;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class DynamicArrayImpl<T> implements Iterable<T>, DynamicArray<T>{

	private T[] array ;
	private int length;
	private int capacity;
	private int index=0;

	public DynamicArrayImpl(int initCapacity){
		if (initCapacity < 0)throw new IllegalArgumentException("Capacity should be greator than or equal to 0, value provided :" + initCapacity + " is not accepted.");
		array = (T[]) new Object[initCapacity];
		this.length = this.capacity = initCapacity;
	}

	public DynamicArrayImpl(){
		this(8);
	}

	public void add(T value){
		if (capacity > 0) {
			array[index] = value;
			index++; capacity--;
		} else { if (length == 0) length=capacity=1;
			T[] newArray = (T[]) new Object[length*2];
			length = newArray.length;
			for(int i=0;i<array.length;i++){
				newArray[i]=array[i];
			}
			array=newArray;
			array[index++]=value;
			capacity += (length/2 - 1);
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

	public T remove(int rmIndex){
		if(rmIndex < 0 && rmIndex >=length) throw new IndexOutOfBoundsException("Remove Index out of size of array.");
		T value = array[rmIndex];
		if (rmIndex == length-1) array[rmIndex]=null;
		else {
			for (int i = rmIndex; i < length - 1; i++) {
				array[i] = array[i + 1];
			}
			array[length - 1] = null;
		}
		capacity++;
		if (capacity%8 == 0) {
			T[] newArr = (T[]) new Object[length/2];
			newArr = array;
			this.array=newArr;
			length=length/2; capacity=0;
		}
		return value;
	}

	public void update(int index, T value) {
		if (index < 0 || index >= length){
			throw new IndexOutOfBoundsException("Index provided is not valid.");
		}
		array[index] = value;
	}

	public void display() {
		for (T value : array) {
			if (value!=null) System.out.print(value);
		}
	}

	@Override
	public int getLength() {
		return length;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public Iterator<T> iterator() {
		return new java.util.Iterator<T>(){
			int index = 0;
			@Override
			public boolean hasNext() {
				return index > length;
			}

			@Override
			public T next() {
				return array[index++];
			}
		};
	}
@Override
	public String toString() {
		if (length == 0) return "[]";
		StringBuilder sb = new StringBuilder(length)
												.append("[ ");
		for (T object : array) {
			if (object != null) sb.append(object + ",");
		}
		return sb.replace(sb.length() -1, sb.length(), " ]").toString();
}
}
