package ed.Stack_Pilha;

import java.util.Stack;

public class TesteDaPilha {

    public static void main(String[] args) {

        // Stack seem a list, but you always will work with the last element.
        Pilha pilha = new Pilha();

        pilha.insere("Joana D'arc");
        System.out.println(pilha);
        pilha.insere("Maria Madalena");
        System.out.println(pilha);
        pilha.insere("Ana Bolena");
        System.out.println(pilha);

        // Whe remove we "cut" the last item of the stack.
        String nome1 = pilha.remove();
        System.out.println(pilha);
        System.out.println(nome1);

        System.out.println("Pilha is empty?");
        System.out.println(pilha.vazia());
        System.out.println("Removing 1");
        pilha.remove();
        System.out.println("Removing 2");
        pilha.remove();

        System.out.println("Pilha is empty?");
        System.out.println(pilha.vazia());

        System.out.println("################################ JAVA STACK ################################");
        //Java has its own implementation of stack
        Stack<String> stack = new Stack<String>();

        stack.push("Joana D'arc");
        System.out.println(stack);
        stack.push("Maria Madalena");
        System.out.println(stack);
        stack.push("Ana Bolena");
        System.out.println(stack);

        // When remove we "cut" the last item of the stack.
        System.out.println("stack.pop");
        String stackName = stack.pop();
        System.out.println(stack);
        System.out.println(stackName);

        // Use peek to "copy" last element of the stack.
        // Similar to pop but peek doesn't remove the element from the stack.
        System.out.println("stack.peek");
        String nome_stack = stack.peek();
        System.out.println(stack);
        System.out.println(nome_stack);

        System.out.println("Stack is empty?");
        System.out.println(stack.isEmpty());
        System.out.println("Removing 1");
        stack.pop();
        System.out.println("Removing 2");
        stack.pop();

        System.out.println("Stack is empty?");
        System.out.println(stack.isEmpty());
    }
}
