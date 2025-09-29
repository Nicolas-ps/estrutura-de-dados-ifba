package Queues.ArrayQueue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static boolean run = true;
    private final static Scanner scanner = new Scanner(System.in);
    private final static ArrayQueue arrayQueue = new ArrayQueue(5);

    public static void main(String[] args) {
        System.out.println("DEMONSTRATIVO DO FUNCIONAMENTO DE UMA FILA\n");
        System.out.println("1 - Queue");
        System.out.println("2 - Enqueue");
        System.out.println("3 - Front");
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
        System.out.print("Digite qualquer valor a ser adicionado na fila: ");
        Object value = scanner.next();

        boolean push = arrayQueue.enqueue(value);
        if (!push) {
            System.out.print("Houve um problema ao enfileirar! Verifique se a fila não está cheia!\n");
        }
    }

    private static void actionTwo() {
        Object pop = arrayQueue.dequeue();
        if (pop == null) {
            System.out.print("Houve um problema ao desenfileirar! Provavelmente a pilha está vazia!\n");
            return;
        }

        System.out.print("A fila foi desenfileirada!");
    }

    private static void actionThree() {
        Object element = arrayQueue.front();
        if (element == null) {
            System.out.print("A filha está vazia!");
            return;
        }

        System.out.print(element);
    }

    private static void actionFour() {
        System.out.print(arrayQueue.print());
    }
}
