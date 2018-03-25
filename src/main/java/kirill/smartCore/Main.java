/**
 * Main класс для запуска приложения
 */
package kirill.smartCore;

import kirill.smartCore.smartCore.controllers.interactoinWithUser.ConsoleBaseboard;

public class Main {

    public static void main(String[] args) {

        ConsoleBaseboard consoleBaseboard = new ConsoleBaseboard();
        consoleBaseboard.firstUserGreeting();
        consoleBaseboard.startSystem();
    }
}