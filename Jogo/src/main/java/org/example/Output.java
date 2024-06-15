package org.example;

import java.util.List;

public class Output {
    public static void imprimirCavernaAtual(Caverna caverna) {
        System.out.println("Você está em uma caverna.");
        if (caverna.getInimigo() != null) {
            System.out.println("Há algo nesta caverna...");
        }
        // Adicionar mais detalhes conforme necessário
    }

    public static void imprimirResultado(String resultado) {
        System.out.println(resultado);
    }

    public static void imprimirMapa(List<Caverna> cavernas, Player player) {
        for (int i = 0; i < cavernas.size(); i++) {
            Caverna caverna = cavernas.get(i);
            if (caverna.isVisitado()) {
                System.out.print("Caverna " + i);
                if (caverna == player.getCavernaAtual()) {
                    System.out.print(" (Jogador)");
                }
                System.out.print(": ");
                if (caverna.getLeste() != null) System.out.print("L ");
                if (caverna.getOeste() != null) System.out.print("O ");
                if (caverna.getNorte() != null) System.out.print("N ");
                if (caverna.getSul() != null) System.out.print("S ");
                System.out.println();
            }
        }
    }
}
