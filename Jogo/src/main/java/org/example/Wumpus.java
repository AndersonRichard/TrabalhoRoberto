package org.example;


public class Wumpus extends Inimigo {
    @Override
    public void acao(Player player) {
        player.setVivo(false);
        System.out.println("Você foi devorado pelo Wumpus!");
    }
}