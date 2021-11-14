package io.andrejackbia.duelarena;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Arena {

    private static final Logger logger = LogManager.getLogger(Arena.class);

    public static void main(String[] args) {
        execute();
    }

    public static int execute() {
        Guerriero gaspare = new Guerriero("Gaspare", 50, 50, 50, 1000);
        Guerriero orazio = new Guerriero("Orazio", 50, 50, 50, 1000);

        logger.debug("Benvenuti alla doubleG arena!");
        logger.debug("Oggi si scontrano " + gaspare.getNome() + " contro " + orazio.getNome());
        logger.debug("COMINCIAMO!!!");
        logger.debug("");

        Guerriero primo;
        Guerriero secondo;
        int rounds = 0;
        do {
            rounds++;

            if (gaspare.getReattivita() * Math.random() > orazio.getReattivita() * Math.random()) {
                primo = gaspare;
                secondo = orazio;
            } else {
                primo = orazio;
                secondo = gaspare;
            }

            logger.debug("ROUND " + rounds);
            logger.debug(primo.getNome() + " prova ad attaccare " + secondo.getNome());
            primo.attacca(secondo);
            if (secondo.isStillAlive()) {
                logger.debug(secondo.getNome() + " prova ad attaccare " + primo.getNome());
                secondo.attacca(primo);
            }
            logger.debug(primo.getNome() + " rimane con " + primo.getVita() + " punti vita.");
            logger.debug(secondo.getNome() + " rimane con " + secondo.getVita() + " punti vita.");
            logger.debug("");
        } while (primo.isStillAlive() && secondo.isStillAlive());

        Guerriero vincitore = null;
        Guerriero perdente = null;
        boolean timeout = false;
        int ret;

        if (!gaspare.isStillAlive() && orazio.isStillAlive()) {
            vincitore = orazio;
            perdente = gaspare;
            ret = 0;
        } else if (gaspare.isStillAlive() && !orazio.isStillAlive()) {
            ret = 1;
            vincitore = gaspare;
            perdente = orazio;
        } else {
            ret = 2;
            timeout = true;
        }
        if (!timeout) {
            logger.debug(perdente.getNome() + " è senza vita!");
            logger.debug(vincitore.getNome() + " vince lo scontro in " + rounds + " round.");
        } else {
            logger.debug("Tempo scaduto!");
            if (gaspare.getVita() > orazio.getVita()) {
                logger.debug(gaspare.getNome() + " vince lo scontro per punti vita.");
            } else if (gaspare.getVita() < orazio.getVita()) {
                logger.debug(orazio.getNome() + " vince lo scontro per punti vita.");
            } else {
                logger.debug("Lo scontro si conclude in piena parità");
            }
        }

        return ret;
    }
}
