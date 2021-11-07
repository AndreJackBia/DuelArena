package io.andrejackbia.duelarena;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Guerriero {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private String nome;
    private int attacco;
    private int difesa;
    private int reattivita;
    private int vita;
    private Arma arma;
    private Armatura armatura;
    private Scudo scudo;

    public Guerriero(String nome, int attacco, int difesa, int reattivita, int vita) {
        this.nome = nome;
        this.attacco = attacco;
        this.difesa = difesa;
        this.reattivita = reattivita;
        this.vita = vita;
        this.arma = new Arma(0);
        this.armatura = new Armatura(0);
        this.scudo = new Scudo(0);
    }

    public void attacca(Guerriero avversario) {
        boolean colpito = this.calcolaPotenzaAttacco(this, avversario);
        if (colpito) {
            logger.debug("L'attacco va a buon fine!");
            int danno = this.calcolaDanno();
            logger.debug("Danno: " + danno);
            int resistenza = this.calcolaResistenza();
            logger.debug("Resistenza: " + resistenza);
            int dannoTotale = Math.max((danno - resistenza), 1);
            avversario.setVita(avversario.getVita() - dannoTotale);
            logger.debug(nome + " infiligge a " + avversario.getNome() + " " + dannoTotale + " danni.");
        } else {
            logger.debug(avversario.getNome() + " respinge l'attacco di " + nome);
        }
    }

    public boolean calcolaPotenzaAttacco(Guerriero attaccante, Guerriero difensore) {
        Random random = new Random();
        int x = random.nextInt(attaccante.getAttacco() + difensore.getReattivita() + 1);
        return x <= attaccante.getAttacco();
    }

    public int calcolaDanno() {
        return (int) ((attacco + arma.getDanno()));
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

    public int getReattivita() {
        return reattivita;
    }

    public void setReattivita(int reattivita) {
        this.reattivita = reattivita;
    }
}
