
public class TestConditional2 {

	public static void main(String[] args) {
		System.out.println("Testing conditionals 2");
		int idade = 10;
		int amountPeople = 2;
//		boolean following = true;
		boolean following = amountPeople >= 2;
		
		System.out.println("Value of amout people: " + amountPeople); 
		
//		AND = &&
//		OR	= ||
		if (idade >= 18 || following) {
			System.out.println("You have more than 18 years old.");
			System.out.println("Welcome");
		} else {

			System.out.println("You can't access.");
		}
	}

}
