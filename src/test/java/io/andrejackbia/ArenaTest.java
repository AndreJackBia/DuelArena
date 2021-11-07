package io.andrejackbia;

import static org.junit.Assert.assertTrue;

import io.andrejackbia.duelarena.Arena;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class ArenaTest {

    private static final Logger logger = LogManager.getLogger(ArenaTest.class);

    @Test
    public void statistics() {
        int gaspare = 0;
        int orazio = 0;
        int timeout = 0;

        for (int i = 0; i < 10000; i++) {
            logger.debug((i + 1));
            int result = Arena.execute();
            if (result == 0)
                orazio++;
            else if (result == 1)
                gaspare++;
            else
                timeout++;
        }
        logger.info("Gaspare: " + gaspare);
        logger.info("Orazio: " + orazio);
        logger.info("Timeout: " + timeout);
    }
}
