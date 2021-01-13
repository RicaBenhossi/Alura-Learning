// EXCEPTION is a CHECKED exception. It means that you must to explicit that 
// it throws an exception on the method that call this exception (see FluxWithTratmentChecked.java)   
// Checked exception means that this has o be treated or be explicit on your code. 
@SuppressWarnings("serial")
public class MyExceptionChecked extends Exception {

		public MyExceptionChecked(String message) {
			super(message);
		}
}
