package kirill.smartCore;

import kirill.smartCore.smartCore.interactoinWithUser.ConsoleBaseboard;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ConsoleBaseboard consoleBaseboard = new ConsoleBaseboard();
        consoleBaseboard.firstUserGreeting();
        consoleBaseboard.startSystem();
    }
}