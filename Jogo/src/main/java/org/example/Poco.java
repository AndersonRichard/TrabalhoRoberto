package org.example;

public class Poco extends Inimigo {
    @Override
    public void acao(Player player) {
        player.decrementarVida();
        System.out.println("Você caiu em um poço! Sua vida foi reduzida.");
    }
}
