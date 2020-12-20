
public class TestVariables {
	public static void main(String[] args) {
		System.out.println("Hello new test.");
		
		int age;
		age = 34;
		
		System.out.println(age);
		
		age = 30 + 10;
		System.out.println(age);
		age = 7*5 + 2;
//		System.out.print doesn't put the cursor in the next line.
		System.out.print(age);
		
		System.out.println("The age is " + age + ", congratulations!");
	}
}
