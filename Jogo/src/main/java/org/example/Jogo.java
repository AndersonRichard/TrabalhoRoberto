package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {
    private List<Caverna> cavernas;
    private Player player;

    public Jogo(int numCavernas) {
        cavernas = new ArrayList<>(numCavernas);
        gerarCavernas(numCavernas);
        posicionarElementos();
        player = new Player(cavernas.get(new Random().nextInt(numCavernas)));
    }

    private void gerarCavernas(int numCavernas) {
        for (int i = 0; i < numCavernas; i++) {
            cavernas.add(new Caverna());
        }

        Random rand = new Random();
        for (Caverna caverna : cavernas) {
            if (rand.nextBoolean() && caverna.getLeste() == null) {
                Caverna cavernaLeste = cavernas.get(rand.nextInt(numCavernas));
                caverna.setLeste(cavernaLeste);
                cavernaLeste.setOeste(caverna);
            }
            if (rand.nextBoolean() && caverna.getOeste() == null) {
                Caverna cavernaOeste = cavernas.get(rand.nextInt(numCavernas));
                caverna.setOeste(cavernaOeste);
                cavernaOeste.setLeste(caverna);
            }
            if (rand.nextBoolean() && caverna.getNorte() == null) {
                Caverna cavernaNorte = cavernas.get(rand.nextInt(numCavernas));
                caverna.setNorte(cavernaNorte);
                cavernaNorte.setSul(caverna);
            }
            if (rand.nextBoolean() && caverna.getSul() == null) {
                Caverna cavernaSul = cavernas.get(rand.nextInt(numCavernas));
                caverna.setSul(cavernaSul);
                cavernaSul.setNorte(caverna);
            }
        }
    }

    private void posicionarElementos() {
        Random rand = new Random();
        cavernas.get(rand.nextInt(cavernas.size())).setInimigo(new Wumpus());
        cavernas.get(rand.nextInt(cavernas.size())).setInimigo(new Poco());
        cavernas.get(rand.nextInt(cavernas.size())).setInimigo(new Morcego());
    }

    public void jogar() {
        while (player.isVivo()) {
            Output.imprimirCavernaAtual(player.getCavernaAtual());
            Output.imprimirMapa(cavernas, player);
            Menu.exibirMenu();
            int opcao = Menu.lerOpcao();
            processarOpcao(opcao);
        }
        Output.imprimirResultado("Fim do jogo!");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                mover(Direcao.LESTE);
                break;
            case 2:
                mover(Direcao.OESTE);
                break;
            case 3:
                mover(Direcao.NORTE);
                break;
            case 4:
                mover(Direcao.SUL);
                break;
            case 5:
                atirarFlecha();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void mover(Direcao direcao) {
        Caverna cavernaDestino = null;
        switch (direcao) {
            case LESTE:
                cavernaDestino = player.getCavernaAtual().getLeste();
                break;
            case OESTE:
                cavernaDestino = player.getCavernaAtual().getOeste();
                break;
            case NORTE:
                cavernaDestino = player.getCavernaAtual().getNorte();
                break;
            case SUL:
                cavernaDestino = player.getCavernaAtual().getSul();
                break;
        }
        if (cavernaDestino != null) {
            player.setCavernaAtual(cavernaDestino);
            if (cavernaDestino.getInimigo() != null) {
                cavernaDestino.getInimigo().acao(player);
            }
        } else {
            System.out.println("Você não pode mover nessa direção.");
        }
    }

    private void atirarFlecha() {
        if (player.getFlechas() > 0) {
            player.decrementarFlechas();
            Caverna cavernaAtual = player.getCavernaAtual();
            Inimigo inimigo = cavernaAtual.getInimigo();

            if (inimigo != null) {
                Random rm = new Random();
                int chance = rm.nextInt(1, 10);
                System.out.println("Você atirou uma flecha.");

                if (chance > 7) {
                    String nomeInimigo = "";
                    if (inimigo instanceof Wumpus) {
                        nomeInimigo = "Wumpus";
                    } else if (inimigo instanceof Poco) {
                        nomeInimigo = "Poco";
                    } else if (inimigo instanceof Morcego) {
                        nomeInimigo = "Morcego";
                    }
                    cavernaAtual.setInimigo(null);
                    System.out.println("Você acertou o " + nomeInimigo + "!");
                } else {
                    System.out.println("A flecha foi jogada ao fundo da caverna e não acertou nada.");
                }
            } else {
                System.out.println("Não há inimigos na caverna para atirar.");
            }
        } else {
            System.out.println("Você não tem flechas.");
        }
    }


    public static void main(String[] args) {
        Jogo jogo = new Jogo(20);
        jogo.jogar();
    }
}
