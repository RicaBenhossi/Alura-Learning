
public class FluxWithTreatmentChecked {

    public static void main(String[] args) {
        System.out.println("Start of main");
        try {
        	method01();
//       Other form to treat checked exception is to catch it on a try..catch 
//       if  you do that, you don't need to explicit on method signature
        } catch (ArithmeticException | NullPointerException | MyExceptionChecked ex) {
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

//  As the MyExceptionChecked is checked, we MUST explicit it in the method signature like bellow.
//  It extends to all the methods that calls method02, like method01
    private static void method02() throws MyExceptionChecked {
        System.out.println("Start of method02");
        throw new MyExceptionChecked("Wrong value.");
        
    }
}
