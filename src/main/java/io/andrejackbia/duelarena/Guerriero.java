package io.andrejackbia.duelarena;

public class Guerriero {

    private String nome;
    private int attacco;
    private int difesa;
    private int vita;
    private Arma arma;
    private Armatura armatura;
    private Scudo scudo;

    public Guerriero(String nome, int attacco, int difesa, int vita) {
        this.nome = nome;
        this.attacco = attacco;
        this.difesa = difesa;
        this.vita = vita;
        this.arma = new Arma(0);
        this.armatura = new Armatura(0);
        this.scudo = new Scudo(0);
    }

    public void attacca(Guerriero avversario) {
        double colpisce = attacco + 10 * Math.random();
        if (colpisce > avversario.calcolaResistenza()) {
            TempLogger.debug("L'attacco va a buon fine!");
            int danno = this.calcolaDanno();
            avversario.setVita(avversario.getVita() - danno);
            TempLogger.debug(nome + " infiligge a " + avversario.getNome() + " " + danno + " danni.");
        } else {
            TempLogger.debug(avversario.getNome() + " respinge l'attacco di " + nome);
        }
    }

    public int calcolaDanno() {
        return (attacco + arma.getDanno());
    }

    public int calcolaResistenza() {
        return difesa + scudo.getResistenza() + armatura.getResistenza();
    }

    public boolean isStillAlive() {
        return vita > 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public int getDifesa() {
        return difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Armatura getArmatura() {
        return armatura;
    }

    public void setArmatura(Armatura armatura) {
        this.armatura = armatura;
    }

    public Scudo getScudo() {
        return scudo;
    }

    public void setScudo(Scudo scudo) {
        this.scudo = scudo;
    }
}
