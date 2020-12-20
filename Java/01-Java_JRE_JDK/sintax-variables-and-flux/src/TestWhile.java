
public class TestWhile {

	public static void main(String[] args) {
//		To the condition of while should be a boolean condition. 
//		If you will use a variable, you should create AND initialize it before while statement.
		int counter = 0;
		while (counter <= 10) {
			System.out.println(counter);
//			All bellow increments 1 t counter
//			counter = counter + 1;
//			counter += 1;
			counter++;
		}
		
		System.out.println(counter);
	}

}
