/**
 * Main класс для запуска приложения
 */
package kirill.smartCore;

import kirill.smartCore.smartCore.controllers.interactoinWithUser.ConsoleBaseboard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("System starting");

        ConsoleBaseboard consoleBaseboard = new ConsoleBaseboard();
        consoleBaseboard.firstUserGreeting();
        consoleBaseboard.startSystem();
    }
}