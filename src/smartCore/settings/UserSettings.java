package smartCore.settings;

import serverClientInteraction.inputControllers.ConsoleReader;
import serverClientInteraction.outputController.ConsolePrinter;
import smartCore.autorithation.User;
import smartCore.storage.UserStorage;

public class UserSettings {

    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsolePrinter consolePrinter = new ConsolePrinter();

    public void firstSatart(){

        createNewUser();



    }

    private void createNewUser(){

        consolePrinter.output("Input your name: ");
        String name = consoleReader.consoleInput().trim();

        consolePrinter.output("Input your password");
        String password = consoleReader.consoleInput().trim();

        consolePrinter.output("Confirm your password");
        String confirmPassword = consoleReader.consoleInput().trim();

        if(password.equals(confirmPassword)){

            User user_1 = new User(name, password);
            UserStorage.saveNewUser(user_1);
        }
        else {
            consolePrinter.output("You input wrong password, please try again");
            createNewUser();
        }
    }

}
