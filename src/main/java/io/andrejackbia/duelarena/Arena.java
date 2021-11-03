package io.andrejackbia.duelarena;

import java.util.Random;

public class Arena {

    public static void main(String[] args) {
        int gaspare = 0;
        int orazio = 0;
        int timeout = 0;

        for (int i = 0; i < 10000; i++) {
            TempLogger.debug((i + 1));
            int result = Integer.parseInt(execute()[0]);
            if (result == 0)
                orazio++;
            else if (result == 1)
                gaspare++;
            else
                timeout++;
        }
        TempLogger.info("Gaspare: " + gaspare);
        TempLogger.info("Orazio: " + orazio);
        TempLogger.info("Timeout: " + timeout);
    }

    public static String[] execute() {
        Guerriero gaspare = new Guerriero("Gaspare", 10, 10, 1000);
        gaspare.setScudo(new Scudo(40));

        Guerriero orazio = new Guerriero("Orazio", 10, 10, 1000);
        orazio.setArma(new Arma(40));

        TempLogger.debug("Benvenuti alla doubleG arena!");
        TempLogger.debug("Oggi si scontrano " + gaspare.getNome() + " contro " + orazio.getNome());
        TempLogger.debug("COMINCIAMO!!!");
        TempLogger.debug();

        Guerriero primo;
        Guerriero secondo;
        Random random = new Random();
        int rounds = 0;
        do {
            rounds++;

            int moneta = random.nextInt(2);
            if (moneta == 0) {
                primo = gaspare;
                secondo = orazio;
            } else {
                primo = orazio;
                secondo = gaspare;
            }

            TempLogger.debug("ROUND " + rounds);
            TempLogger.debug(primo.getNome() + " prova ad attaccare " + secondo.getNome());
            primo.attacca(secondo);
            if (secondo.isStillAlive()) {
                TempLogger.debug(secondo.getNome() + " prova ad attaccare " + primo.getNome());
                secondo.attacca(primo);
            }
            TempLogger.debug();
        } while (primo.isStillAlive() && secondo.isStillAlive() && rounds < 10000);

        Guerriero vincitore = null;
        Guerriero perdente = null;
        boolean timeout = false;
        int ret;

        if (!gaspare.isStillAlive() && orazio.isStillAlive()) {
            vincitore = orazio;
            perdente = gaspare;
            ret = 0;
        } else if (primo.isStillAlive() && !secondo.isStillAlive()) {
            ret = 1;
            vincitore = gaspare;
            perdente = orazio;
        } else {
            ret = 2;
            timeout = true;
        }
        if (!timeout) {
            TempLogger.debug(perdente.getNome() + " è senza vita!");
            TempLogger.debug(vincitore.getNome() + " vince lo scontro in " + rounds + " round.");
        } else {
            TempLogger.debug("Tempo scaduto!");
            if (gaspare.getVita() > orazio.getVita()) {
                TempLogger.debug(gaspare.getNome() + " vince lo scontro per punti vita.");
            } else if (gaspare.getVita() < orazio.getVita()) {
                TempLogger.debug(orazio.getNome() + " vince lo scontro per punti vita.");
            } else {
                ret = 2;
                TempLogger.debug("Lo scontro si conclude in piena parità");
            }
        }

        return new String[] { ret + "" };
    }
}
