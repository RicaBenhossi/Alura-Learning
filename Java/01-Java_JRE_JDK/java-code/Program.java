public class Program {
    public static void main(String[] args){
        System.out.println("hello world");
        message("Welcome to Java!");
        System.out.println(WelcomeMessage("Ricardo"));
    }

    public static void message(String message_to_print) {
        System.out.println(message_to_print);
    }

    public static String WelcomeMessage(String name) {

        return "I hope your name is " + name;
    }
}