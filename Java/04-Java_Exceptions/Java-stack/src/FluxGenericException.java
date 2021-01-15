
public class FluxGenericException {

    public static void main(String[] args) {
        System.out.println("Start of main");
        try {
        	method01();
//      The classes MyExceptionChecked (Checked), NullPointerException (Checked) and ArithmeticException ((Checked) have 
//      an ancestor in common: all of the, directly (MyExceptionChecked) or indirectly (NullPointerExceptionand ArithmeticException)
//      extends from EXCEPTION. So we can use POLYMORPHISM here to catch all exception. 
        } catch (Exception ex) {
        	System.out.println("Exception");
        	ex.printStackTrace();
        }
        System.out.println("End of main");
    }

    private static void method01() throws MyExceptionChecked {
        System.out.println("Start of method01");
		method02();
        System.out.println("End of method01");
    }

    private static void method02() throws MyExceptionChecked {
        System.out.println("Start of method02");
        throw new MyExceptionChecked("Something is wrong.");
        
    }
}
