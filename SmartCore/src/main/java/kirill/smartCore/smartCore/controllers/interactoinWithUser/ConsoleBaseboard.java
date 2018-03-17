/**
 * Данный класс реализует системное меню для взаимодействия системы с пользователем,
 * которое открывается при запуске системы.
 */

package kirill.smartCore.smartCore.controllers.interactoinWithUser;

import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.InputRouter;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.ComPortOutputRouter;
import kirill.smartCore.smartCore.controllers.interactoinWithUser.settings.ConsoleUserSettings;
import kirill.smartCore.smartCore.model.User;
import kirill.smartCore.smartCore.model.storage.UserStorage;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.ConsoleReader;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.ConsolePrinter;

public class ConsoleBaseboard implements IUserInteraction {

    private static final String SYSTEM_Name = "<<YUI>>";
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    private static final InputRouter inputRouter = new InputRouter();
    private static final ComPortOutputRouter comOutputRouter = new ComPortOutputRouter();

    @Override
    public void startSystem() throws InterruptedException {
        inputRouter.inputSignal();
    }

    @Override
    public void firstUserGreeting() throws InterruptedException {

        consolePrinter.output(String.format("Welcome to Your Smart Home system.\nMy name is %s, and I am your home assistant\n", SYSTEM_Name));

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
    public void firstStartSystem() throws InterruptedException {

        consolePrinter.output("I see, you are not registered in this system, let's register!");
        ConsoleUserSettings.createNewUser();
        ConsoleUserSettings.addNewAreas();
        startSystem();
    }


    @Override
    public void userMenu() {

    }

    private boolean authorization(){

        consolePrinter.output("Please, input your registration name:");
        String userName = consoleReader.consoleInput();

        consolePrinter.output("Please, input your password name:");
        String password = consoleReader.consoleInput();

        User userAuthorization = UserStorage.getUser(userName);

        return userAuthorization.getUserName().equals(userName) && userAuthorization.getUserPassword().equals(password);
    }
}
