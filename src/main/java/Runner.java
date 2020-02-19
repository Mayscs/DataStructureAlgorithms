public class Runner {
	public static void main(String[] args) {
		DynamicArray dynamicArray = new DynamicArrayImpl(2);

		dynamicArray.add("I");
		dynamicArray.add(" am");
		dynamicArray.add(" born");
		dynamicArray.add(" with Potential.");
		dynamicArray.add(" I'll fly");
		System.out.println(((DynamicArrayImpl) dynamicArray).getLength());
		System.out.println(((DynamicArrayImpl) dynamicArray).iterator().next());
		((DynamicArrayImpl) dynamicArray).iterator().forEachRemaining(System.out :: println);
		dynamicArray.display();
		System.out.println(dynamicArray.toString());
	}
}
