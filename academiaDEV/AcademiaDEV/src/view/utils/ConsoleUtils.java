package view.utils;

/**
 * This class provides utility methods for interacting with the console.
 * @clearScreen -> clear the console screen.
 */

public class ConsoleUtils {
    public static void clearScreen() {
        try {
            // clear windows console
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            // clear others os
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ex) {
            // if fail only put whitelines
            for (int i = 0; i < 50; i++)
                System.out.println();
        }
    }
}
