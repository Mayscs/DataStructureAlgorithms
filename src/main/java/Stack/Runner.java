package Stack;

public class Runner {
	public static void main(String[] args) {

		System.out.println("~~~~~~~~~~~~ STACK ~~~~~~~~~~~~~");
		Stack<Integer> denominations = new StackImpl<Integer>();

		denominations.push(10);
		denominations.push(10);
		denominations.push(2);
		denominations.push(1);
		denominations.push(5);

		System.out.println(String.format("\n\nTotal %s coins in the heap. \n", denominations.getSize()));
		System.out.println("Top Element of stack - " + denominations.peek());
		System.out.println("Take element out of stack and show me.\nAye Sir !! It is " + denominations.pop());
		System.out.println( "Stack Values" + "\n" + denominations.toString());


		Stack<String> currencyNotes = new StackImpl<String>();
		System.out.println("Stack Values" + "\n" + currencyNotes.toString());
		currencyNotes.push("Twenty");
		currencyNotes.push("Ten");
		currencyNotes.push("Hundred");
		currencyNotes.push("Thousand");
		System.out.println("Stack Values" + "\n" + currencyNotes.toString());

	}
}
