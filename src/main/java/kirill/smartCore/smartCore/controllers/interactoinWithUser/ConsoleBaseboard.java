/**
 * Данный класс реализует системное меню для взаимодействия системы с пользователем,
 * которое открывается при запуске системы.
 */

package kirill.smartCore.smartCore.controllers.interactoinWithUser;

import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.InputRouter;
import kirill.smartCore.smartCore.controllers.interactoinWithUser.settings.ConsoleUserSettings;
import kirill.smartCore.smartCore.exceptions.ConnectionFailedException;
import kirill.smartCore.smartCore.model.User;
import kirill.smartCore.smartCore.model.storage.UserStorage;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.ConsoleReader;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.ConsolePrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleBaseboard implements IUserInteraction {

    private static final String SYSTEM_Name = "<<YUI>>";

    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    private static final InputRouter inputRouter = new InputRouter();
    private final UserConsoleMenu userConsoleMenu = new UserConsoleMenu();

    private static StringBuilder userMenuBuilder = new StringBuilder();

    private static final Logger logger = LogManager.getLogger(ConsoleBaseboard.class.getName());

    static {
        userMenuBuilder.append("\n==USER MENU==\n")
                .append("This is user menu, for navigate on this, please input specific values:")
                .append("Add new areas - 1")
                .append("Change your password - 2")
                .append("Add new user - 3")
                .append("Add area settings - 4")
                .append("System ShutDown - 0");
    }

    @Override
    public final void startSystem() {
        try {
            inputRouter.inputSignal();
        } catch (ConnectionFailedException e) {
            logger.error("Connection error, restart system!");
            inputRouter.restartInputConnection();
        }

        userConsoleMenu.userMenu();
    }

    @Override
    public void firstUserGreeting() {
        consolePrinter.output(String.format("Welcome to Your Smart Home system.\nMy name is %s, and I am your home assistant\n", SYSTEM_Name));

        if (isFirstStart()) {
            firstStartSystem();
        } else {
            if (authorization()) {
                consolePrinter.output("Success!");
                startSystem();
            } else {
                consolePrinter.output("You input incorrect values!");
                userConsoleMenu.userMenu();
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
        startSystem();
    }

    private boolean authorization() {
        consolePrinter.output("Please, input your registration name:");
        String userName = consoleReader.consoleInput();

        consolePrinter.output("Please, input your password name:");
        String password = consoleReader.consoleInput();

        User userAuthorization = UserStorage.getUser(userName);

        if (userAuthorization.getUserName().equals(UserStorage.NOT_FOUND)) {
            logger.error("User is NOT FOUND!");
            return false;
        }

        return userAuthorization.getUserName().equals(userName)
                && userAuthorization.getUserPassword().equals(password);
    }

    private class UserConsoleMenu {

        private final String NEW_AREA = "1";
        private final String CHANGE_PASSWORD = "2";
        private final String NEW_USER = "3";
        private final String AREA_SETTINGS = "4";
        private final String SYSTEM_SHUTDOWN = "0";

        private boolean systemWorking = true;
        private String userInput;

        private void userMenu() {

            while (systemWorking) {
                consolePrinter.output(userMenuBuilder);
                userInput = consoleReader.consoleInput().trim();

                switch (userInput) {
                    case NEW_AREA: {
                        ConsoleUserSettings.addNewAreas();
                        break;
                    }
                    case CHANGE_PASSWORD: {
                        consolePrinter.output("\nInput user name:");
                        String currentUserName = consoleReader.consoleInput();
                        consolePrinter.output("\nInput your current password:");
                        String currentPassword = consoleReader.consoleInput();

                        User currentUser = UserStorage.getUser(currentUserName);
                        currentUser.changePassword(currentUserName, currentPassword);
                        break;
                    }
                    case NEW_USER: {
                        ConsoleUserSettings.createNewUser();
                        break;
                    }
                    case AREA_SETTINGS: {
                        consolePrinter.output("This function doesn't realized yet!");
                        break;
                    }
                    case SYSTEM_SHUTDOWN: {
                        systemWorking = false;
                        InputRouter.closeConnection();
                        break;
                    }
                }
            }
        }
    }
}
