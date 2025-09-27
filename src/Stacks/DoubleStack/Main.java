package Stacks.DoubleStack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static boolean run = true;
    private final static Scanner scanner = new Scanner(System.in);
    private final static DoubleArrayStack doubleArrayStack = new DoubleArrayStack();

    public static void main(String[] args) {
        System.out.println("DEMONSTRATIVO DO FUNCIONAMENTO DE UMA DOUBLE STACK\n");
        System.out.println("1 - Push");
        System.out.println("2 - Pop");
        System.out.println("3 - Peek");
        System.out.println("4 - Print");
        System.out.print("0 - Exit\n");

        int option;
        while (run) {
            System.out.print("\nDigite a ação: ");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException _) {
                option = 0;
            }

            if (option == 1) {

                actionOne();
            }

            if (option == 2) {
                actionTwo();
            }

            if (option == 3) {
                actionThree();
            }

            if (option == 4) {
                actionFour();
            }

            if (option == 0) {
                run = false;
            }
        }
    }

    private static void actionOne() {
        System.out.print("Digite qualquer valor a ser adicionado na pilha: ");
        Object value = scanner.next();

        System.out.print("Digite o ID da pilha (1 ou 2) em que o valor digitado deve ser adicionado: ");
        int stackIndex = scanner.nextInt();
        boolean push = doubleArrayStack.push(stackIndex, value);
        if (!push) {
            System.out.print("Houve um problema ao empilhar! Verifique se a pilha não está cheia!\n");
        }
    }

    private static void actionTwo() {
        System.out.println("Digite o ID da pilha que deve ser desempilhada: ");
        int stackIndex = scanner.nextInt();

        Object pop = doubleArrayStack.pop(stackIndex);
        if (pop == null) {
            System.out.print("Houve um problema ao desempilhar! Provavelmente a pilha está vazia!\n");
        }

        System.out.print("A pilha foi desempilhada!");
    }

    private static void actionThree() {
        System.out.println("Digite o ID da pilha que você deseja espiar: ");
        int stackIndex = scanner.nextInt();

        System.out.print(doubleArrayStack.peek(stackIndex));
    }

    private static void actionFour() {
        doubleArrayStack.print();
    }
}
