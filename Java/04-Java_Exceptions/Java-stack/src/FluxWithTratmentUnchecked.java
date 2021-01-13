
public class FluxWithTratmentUnchecked {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
        	metodo1();
//        } catch (ArithmeticException | NullPointerException ex) {
        } catch (ArithmeticException | NullPointerException | MyExceptionUnchecked ex) {
        	System.out.println("Exception");
        	ex.printStackTrace();
        }
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
     	metodo2();
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo2");
//      Command throw raise an exception to stack 
//        throw new ArithmeticException("Wrong Value");
//        System.out.println("Fim do metodo2");
        throw new MyExceptionUnchecked("Wrong value passed");
    }
}
