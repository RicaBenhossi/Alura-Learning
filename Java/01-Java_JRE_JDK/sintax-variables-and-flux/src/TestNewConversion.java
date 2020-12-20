
public class TestNewConversion {
	public static void main(String[] args) {
//		floating points
//			double: 64 bits
//			float: 32 bits
//		integers
//			int: 32 bits (negative 2^31 to 2^31 positive -1 because the 0 is in between)
//			long: 64 bits
//			short: 16 bits
//			byte: 8 bits
		double salary = 1270.50;
		float floatPoint = 3.14f;
		System.out.println(floatPoint);
		 
//		A double doesn't fit in a integer. You need to cast it.
		int value = (int) salary;
		System.out.println(value);
		
		long bigNumber = 3421243434L;
		 
		double value1 = 0.2;
		double value2 = 0.1;
		double total = value1 + value2;
		 
		System.out.println(total);
		
		
		 
	}
}
