package io.andrejackbia.duelarena;

import java.util.Arrays;

public class TempLogger {

    private static final int LEVEL = 0;

    public static void info(Object... input) {
        if (0 <= LEVEL)
            System.out.println(Arrays.toString(input));
    }

    public static void error(Object... input) {
        if (-1 <= LEVEL)
            System.out.println(Arrays.toString(input));
    }

    public static void debug(Object... input) {
        if (1 <= LEVEL)
            System.out.println(Arrays.toString(input));
    }
}
