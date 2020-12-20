
public class TestCharacters {
	public static void main(String[] agrs) {
//		in char is mandatory the use of ''
//		char represents a unicode code
		char character = 'a';
		System.out.println(character);
		
		char value = 66;
		System.out.println(value);
		
//		If you want to plus, you need to cast
		value = (char) (value + 1);
		System.out.println(value);
		
//		String is not a Java primitive type. Is mandatory the use of ""
		String word = "alura online technology courses";
		
		System.out.println(word);

//		When use string, it automatically casts other to string
		word = word + 2020;
		System.out.println(word);				
	}
}
