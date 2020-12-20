
public class TestFor {

	public static void main(String[] args) {
//		for (1; 2; 3) {}
//		1: initialization of the counter (executed only the first time); 
//		2: boolean conditional to validate counter (run every loop); 
//		3: increment of counter (executed every time except first time)
		for (int counter = 0; counter <= 10; counter++) {
			System.out.println(counter);
		}
//		This not work because counter is valid only in the "for" scope 
//		System.out.println(counter);
	}

}
