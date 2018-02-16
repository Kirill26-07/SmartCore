/**
 * Данный класс реализует системное меню для взаимодействия системы с пользователем,
 * которое открывается при запуске системы.
 */

package smartCore.interactoinWithUser;

import smartCore.controllers.serverClientInteraction.inputControllers.ConsoleReader;
import smartCore.controllers.serverClientInteraction.outputController.ConsolePrinter;
import smartCore.interactoinWithUser.settings.ConsoleUserSettings;
import smartCore.storage.UserStorage;

public class ConsoleBaseboard implements IUserInteraction {

    private static final String SYSTEM_Name = "<<YUI>>";
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final ConsoleReader consoleReader = new ConsoleReader();


    @Override
    public void firstUserGreeting() {

        consolePrinter.output(String.format("Welcome to Your Smart Home system. My name is %s, and I am your home assistant", SYSTEM_Name));

        if(isFirstStart()){
            firstStartSystem();
        }
        else {
            if(authorization()){
                consolePrinter.output("Success!");
                startSystem();
            }
            else{
                consolePrinter.output("You input incorrect values!");
                userMenu();
            }
        }
    }

    @Override
    public boolean isFirstStart() {

        return UserStorage.getUserStorage().isEmpty();
    }

    @Override
    public void firstStartSystem() {

        consolePrinter.output("I see, you are not registered in this system, let's register!");
        ConsoleUserSettings.createNewUser();
        ConsoleUserSettings.addNewAreas();
    }

    @Override
    public void startSystem() {

    }

    @Override
    public void userMenu() {

    }

    private boolean authorization(){

        consolePrinter.output("Please, input your registration name:");
        String userName = consoleReader.consoleInput();

        consolePrinter.output("Please, input your password name:");
        String password = consoleReader.consoleInput();

        return UserStorage.getUser(userName).userAuthorization(userName, password);
    }
}
