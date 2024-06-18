package org.example;

import java.util.List;

public class Output {
    public static void imprimirCavernaAtual(Caverna caverna) {
        System.out.println("Você está em uma caverna.");
        if (caverna.getInimigo() != null) {
            System.out.println("Há algo nesta caverna...");
        }

    }

    public static void imprimirResultado(String resultado) {
        System.out.println(resultado);
    }

    public static void imprimirMapa(List<Caverna> cavernas, Player player) {
        System.out.println("Mapa da Caverna:");
        for (int i = 0; i < cavernas.size(); i++) {
            Caverna caverna = cavernas.get(i);
            if (caverna.isVisitado()) {
                String simboloCaverna = caverna == player.getCavernaAtual() ? "J" : "C";
                String corSimbolo = caverna == player.getCavernaAtual() ? "\033[0;32m" : "\033[0;34m"; // Verde para o jogador, azul para as cavernas

                System.out.print(corSimbolo + simboloCaverna + "\033[0m" + " " + i);
                if (caverna.getInimigo() != null) {
                    String simboloInimigo;
                    if (caverna.getInimigo() instanceof Wumpus) {
                        simboloInimigo = "W";
                    } else if (caverna.getInimigo() instanceof Poco) {
                        simboloInimigo = "P";
                    } else {
                        simboloInimigo = "M";
                    }
                    System.out.print(" (" + simboloInimigo + ")");
                }
                System.out.print(": ");
                if (caverna.getLeste() != null) System.out.print("L ");
                if (caverna.getOeste() != null) System.out.print("O ");
                if (caverna.getNorte() != null) System.out.print("N ");
                if (caverna.getSul() != null) System.out.print("S ");
                System.out.println();
            }
        }
        System.out.println("\nLegenda: J - Jogador, C - Caverna, W - Wumpus, P - Poço, M - Morcego");
    }
}
