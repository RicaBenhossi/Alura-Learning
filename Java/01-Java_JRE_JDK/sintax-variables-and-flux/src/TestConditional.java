
public class TestConditional {

	public static void main(String[] args) {
		System.out.println("Testing conditionals");
		int idade = 10;
		int amountPeople = 3;

		if (idade >= 18) {
			System.out.println("You have more than 18 years old.");
			System.out.println("Welcome");
		} else {
			if (amountPeople >= 2) {
				System.out.println("You have not 18 years old, but can acccess because you are "
						+ "accompanying 2 people.");
			}
			System.out.println("You can't access.");
		}

	}

}
