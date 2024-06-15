package org.example;

public class Morcego extends Inimigo {
    @Override
    public void acao(Player player) {
        player.transporteAleatorio();
        System.out.println("Um morcego te levou para outra caverna!");
    }
}