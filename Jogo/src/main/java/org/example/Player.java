package org.example;

public class Player {
    private Caverna cavernaAtual;
    private int vida;
    private int flechas;
    private boolean vivo;

    public Player(Caverna cavernaInicial) {
        this.cavernaAtual = cavernaInicial;
        this.vida = 100;
        this.flechas = 3;
        this.vivo = true;
        cavernaInicial.setVisitado(true);
    }

    public Caverna getCavernaAtual() {
        return cavernaAtual;
    }

    public void setCavernaAtual(Caverna cavernaAtual) {
        this.cavernaAtual = cavernaAtual;
        cavernaAtual.setVisitado(true);
    }

    public int getVida() {
        return vida;
    }

    public void decrementarVida() {
        this.vida -= 50;
        if (this.vida <= 0) {
            this.vivo = false;
        }
    }

    public int getFlechas() {
        return flechas;
    }

    public void decrementarFlechas() {
        this.flechas--;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void transporteAleatorio() {
        // Lógica para transporte aleatório
    }
}
