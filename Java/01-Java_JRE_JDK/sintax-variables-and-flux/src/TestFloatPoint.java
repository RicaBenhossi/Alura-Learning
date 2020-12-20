
public class TestFloatPoint {
	public static void main(String[] args) {
		double salary;
		salary = 1250.70;
		
		System.out.println("My salary is " + salary);
		
		double age = 37;
		System.out.println(age);
		
		double division = 3.14 / 2;
		System.out.println(division);
		
//		In Java, if the division is between 2 int, the result will be int.
		int anotherDivision = 5 / 2;
		System.out.println(anotherDivision);
		
//		Java always resolve the right side of the statement first. In this case, as we have a double, the result will be expressed in double. 
		double moreOneDivision = 5.0 / 2;
		System.out.println(moreOneDivision);
	}
}
