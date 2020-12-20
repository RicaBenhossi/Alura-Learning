
public class TestScope {

	public static void main(String[] args) {
//		System.out.println("Testing conditionals 2");
		int idade = 10;
		int amountPeople = 2;
//		boolean following = amountPeople >= 2;
		boolean following;
		
//		In Java, the scope of variables is the {}.
//		In this case, the variable youHaveCompany "dies" at the close parenthesis and is not available outside it. 
//		If you need a value that is calculated on IF, you need to declare a variable outside and before if.	
		if (amountPeople >= 2 ) {
			boolean youHaveCompany = true;
			following = youHaveCompany;
		} else {
			boolean youHaveCompany =false;
			following = youHaveCompany;
		}
		
		System.out.println("Value of following: " + following); 
		
		if (idade >= 18 || following) {
			System.out.println("You have more than 18 years old.");
			System.out.println("Welcome");
		} else {

			System.out.println("You can't access.");
		}
	}
}
