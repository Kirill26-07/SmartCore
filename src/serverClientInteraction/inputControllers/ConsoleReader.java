package serverClientInteraction.inputControllers;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner = new Scanner(System.in);

    public String consoleInput(){

        return scanner.nextLine();

    }

}
