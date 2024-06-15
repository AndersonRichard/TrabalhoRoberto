package org.example;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenu() {
        System.out.println("Escolha uma ação:");
        System.out.println("1. Mover para o Leste");
        System.out.println("2. Mover para o Oeste");
        System.out.println("3. Mover para o Norte");
        System.out.println("4. Mover para o Sul");
        System.out.println("5. Atirar flecha");
        System.out.println("6. Sair");
    }

    public static int lerOpcao() {
        System.out.print("Opção: ");
        return scanner.nextInt();
    }
}



