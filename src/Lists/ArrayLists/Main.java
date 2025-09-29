package Lists.ArrayLists;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static boolean run = true;
    private final static Scanner scanner = new Scanner(System.in);
    private final static ArrayList arrayList = new ArrayList();

    public static void main(String[] args) {
        System.out.println("DEMONSTRATIVO DO FUNCIONAMENTO DE UMA LISTA\n");
        System.out.println("1 - Append");
        System.out.println("2 - Insert");
        System.out.println("3 - Select");
        System.out.println("4 - Delete");
        System.out.println("5 - Update");
        System.out.println("6 - Select All");
        System.out.println("7 - Clear");
        System.out.println("8 - Print");
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

            if (option == 5) {
                actionFive();
            }

            if (option == 6) {
                actionSix();
            }

            if (option == 7) {
                actionSeven();
            }

            if (option == 8) {
                actionEight();
            }

            if (option == 0) {
                run = false;
            }
        }
    }

    private static void actionOne() {
        System.out.print("Digite qualquer valor a ser adicionado ao fim da lista: ");
        Object value = scanner.next();

        boolean append = arrayList.append(value);
        if (!append) {
            System.out.print("Houve um problema ao adicionar! Verifique se a lista não está cheia!\n");
            return;
        }

        System.out.println("A lista foi modificada!");
    }

    private static void actionTwo() {
        System.out.print("Digite qualquer valor a ser inserido na lista: ");
        Object value = scanner.next();

        System.out.print("Digite o índice em que o valor será inserido: ");
        int index = scanner.nextInt();

        boolean insert;
        try {
            insert = arrayList.insert(value, index);
        } catch (IndexOutOfBoundsException exception) {
            System.out.print("Houve um problema ao inserir! O índice não existe!\n");
            return;
        }

        if (! insert) {
            System.out.print("Houve um problema ao inserir! Provavelmente a lista está cheia!\n");
            return;
        }

        System.out.println("A lista foi modificada!");
    }

    private static void actionThree() {
        System.out.print("Digite o índice do qual você deseja recuperar o valor na lista: ");
        int index = scanner.nextInt();

        Object element;
        try {
            element = arrayList.select(index);
        } catch (IndexOutOfBoundsException exception) {
            System.out.print("Houve um problema. O índice não existe!");
            return;
        }

        System.out.println(element);
    }

    private static void actionFour() {
        System.out.print("Digite o índice do qual você deseja deletar o valor da lista: ");
        int index = scanner.nextInt();

        Object element;
        try {
            element = arrayList.delete(index);
        } catch (IndexOutOfBoundsException exception) {
            System.out.print("Houve um problema. O índice não existe!");
            return;
        }

        System.out.println(element);
    }

    private static void actionFive() {
        System.out.print("Digite qualquer valor a ser inserido na lista: ");
        Object value = scanner.next();

        System.out.print("Digite o índice em que o novo valor será inserido: ");
        int index = scanner.nextInt();

        boolean updated = false;
        try {
            updated = arrayList.update(value, index);
        } catch (IndexOutOfBoundsException exception) {
            System.out.print("Houve um problema. O índice não existe!");
        }

        if (! updated) {
            System.out.print("Houve um problema ao atualizar a lista. Verifique se a mesma não está cheia!");
            return;
        }

        System.out.println("A lista foi modificada!");
    }

    public static void actionSix() {
        Object[] all = arrayList.selectAll();
        System.out.print("All elements: [");
        for (int i = 0; i < all.length; i++) {
            System.out.print(all[i]);
            if (i != all.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void actionSeven() {
        arrayList.clear();
    }

    public static void actionEight() {
        System.out.println(arrayList.print());
    }
}
