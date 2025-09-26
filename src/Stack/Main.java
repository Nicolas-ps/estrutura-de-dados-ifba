package Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        ArrayStack arrayStack = new ArrayStack();

        System.out.println("DEMONSTRATIVO DO FUNCIONAMENTO DE UMA STACK\n");
        System.out.println("1 - Push");
        System.out.println("2 - Pop");
        System.out.println("3 - Print");
        System.out.println("4 - Peek");
        System.out.print("0 - Exit\n");

        while (run) {
            System.out.print("\nDigite a ação: ");
            int option = scanner.nextInt();


            Object value;
            switch (option) {
                case 1:
                    System.out.print("Digite qualquer valor a ser adicionado na pilha: ");
                    value = scanner.next();

                    boolean push = arrayStack.push(value);
                    if (!push) {
                        System.out.print("Houve um problema ao empilhar! Verifique se a pilha não está cheia!\n");
                    }

                    break;
                case 2:
                    Object pop = arrayStack.pop();
                    if (pop == null) {
                        System.out.print("Houve um problema ao desempilhar! Provavelmente a pilha está vazia!\n");
                        break;
                    }

                    System.out.println("A pilha foi desempilhada!");
                    break;
                case 3:
                    System.out.println(arrayStack.print());
                    break;
                case 4:
                    System.out.println(arrayStack.peek());
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }
}