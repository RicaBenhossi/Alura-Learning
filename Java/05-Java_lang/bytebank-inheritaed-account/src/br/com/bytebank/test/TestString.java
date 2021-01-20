package br.com.bytebank.test;

import java.util.Iterator;

public class TestString {

	public static void main(String[] args) {
		
//		String is a class. So it works like bellow BUT we don't need to use new.
//		Although it is considered bad practice.
//		String name = new String("Alura");
		
//		To declare a string we use this way, that is called OBJECT LITERAL
		String name = "Alura";
		
//		It doesn't work. Strings in java are immutable. So, these methods returns another string to be used or printed.
		name.replace("A", "a");
		System.out.println(name);
		name.toLowerCase();
		System.out.println(name);
		
//		If we want to "change" a String, we must store its variation into another string.
		String name2 = name.replace("A", "a");
		System.out.println(name2);
		System.out.println(name);
		
//		Replacing CHAR. Char is a type represented by ' instead ".
		String repchar = name.replace('l', 'L');	
		System.out.println(repchar);
		
		char testCharAt = name.charAt(2);
		System.out.println(testCharAt);
		
		int positionOf = name.indexOf("ur");
		System.out.println(positionOf);
		
		String subString = name.substring(1);
		System.out.println(subString);
		
		System.out.println(name.length());
		
		for (int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i));
		}
		
		String emptyStr = "";
		System.out.println(emptyStr.isEmpty());
		
		String emptyStr2 = " ";
		System.out.println(emptyStr2.isEmpty());
		
		String emptyStr3 = "";
		System.out.println(emptyStr3.isBlank());
		
		String emptyStr4 = " ";
		System.out.println(emptyStr4.isBlank());
		
		String testNoSpaces = "     ALURA     ";
		System.out.println(testNoSpaces);
		String noSpaces = testNoSpaces.trim();
		System.out.println(noSpaces);
		
		System.out.println(name.contains("lur"));
		System.out.println(name.contains("As"));
		
	}

}
