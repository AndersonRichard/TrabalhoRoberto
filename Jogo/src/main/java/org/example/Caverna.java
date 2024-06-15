package org.example;

public class Caverna {
    private Caverna leste;
    private Caverna oeste;
    private Caverna norte;
    private Caverna sul;
    private Inimigo inimigo;
    private boolean visitado;

    public Caverna() {
        this.visitado = false;
    }

    public Caverna getLeste() {
        return leste;
    }

    public void setLeste(Caverna leste) {
        this.leste = leste;
    }

    public Caverna getOeste() {
        return oeste;
    }

    public void setOeste(Caverna oeste) {
        this.oeste = oeste;
    }

    public Caverna getNorte() {
        return norte;
    }

    public void setNorte(Caverna norte) {
        this.norte = norte;
    }

    public Caverna getSul() {
        return sul;
    }

    public void setSul(Caverna sul) {
        this.sul = sul;
    }

    public Inimigo getInimigo() {
        return inimigo;
    }

    public void setInimigo(Inimigo inimigo) {
        this.inimigo = inimigo;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}

