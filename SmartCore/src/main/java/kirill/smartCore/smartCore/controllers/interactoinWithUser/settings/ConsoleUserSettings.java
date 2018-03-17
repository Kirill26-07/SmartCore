/**
 * Данный класс предназначен для предварительной настройки системы, а также для изменения настроек
 * во время ее использования.
 * Основной функционал:
 * - Первичная настройка системы, включающая создания пользователей и создание зонированных участков дома
 * для точной их настройки под себя.
 */

package kirill.smartCore.smartCore.controllers.interactoinWithUser.settings;

import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.ComPortOutputRouter;
import kirill.smartCore.smartCore.model.IHomeArea;
import kirill.smartCore.smartCore.model.storage.ControllerID;
import kirill.smartCore.smartCore.model.storage.ExternalCommands;
import kirill.smartCore.smartCore.model.storage.UserStorage;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.ConsoleReader;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.ConsolePrinter;
import kirill.smartCore.smartCore.model.HomeArea;
import kirill.smartCore.smartCore.model.User;
import kirill.smartCore.smartCore.controllers.energyControllers.ClimateController;
import kirill.smartCore.smartCore.controllers.energyControllers.Lighting;
import kirill.smartCore.smartCore.controllers.securityControllers.AccessController;
import kirill.smartCore.smartCore.controllers.securityControllers.GasController;
import kirill.smartCore.smartCore.controllers.securityControllers.WaterController;
import kirill.smartCore.smartCore.model.storage.AreasStorage;


public class ConsoleUserSettings {

    private static ComPortOutputRouter outputRouter = new ComPortOutputRouter();
    private static ConsoleReader consoleReader = new ConsoleReader();
    private static ConsolePrinter consolePrinter = new ConsolePrinter();

    public static void createNewUser() {

        ConsoleUserSettings.consolePrinter.output("\nInput your name: ");
        String name = ConsoleUserSettings.consoleReader.consoleInput().trim();

        boolean passwordConfirm = false;
        do {
            ConsoleUserSettings.consolePrinter.output("\nInput your password");
            String password = ConsoleUserSettings.consoleReader.consoleInput().trim();

            ConsoleUserSettings.consolePrinter.output("\nConfirm your password");
            String confirmPassword = ConsoleUserSettings.consoleReader.consoleInput().trim();

            if (password.equals(confirmPassword)) {
                User user = new User(name, password);
                UserStorage.saveNewUser(user);
                passwordConfirm = true;
            } else {
                ConsoleUserSettings.consolePrinter.output("\nYou input wrong password, please try again");
            }
        }
        while (!passwordConfirm);

    }

    public static void addNewAreas() {

        StringBuilder stringBuilder = new StringBuilder();

        ConsoleUserSettings.consolePrinter.output(stringBuilder.append("\nSelect the area you want to create.")
                .append("\nNow we improve six types of home module: ")
                .append("\n1 - Kitchen;")
                .append("\n2 - Bad room;")
                .append("\n3 - Living room;")
                .append("\n4 - Lobby;")
                .append("\n5 - Bathroom;")
                .append("\n6 - Toilet.\n")
                .append("\nInput numbers of types to create that model:\n")
                .append("\nAvailable controllers will be added automatically!\n")
                .append("\nInput your types by entering, to complete input - Q!"));

        boolean userComplete = false;

        while (!userComplete) {

            String typesOfAreas = ConsoleUserSettings.consoleReader.consoleInput().toLowerCase();

            switch (typesOfAreas) {
                case "1":
                    IHomeArea kitchen = new HomeArea(AreasStorage.KITCHEN_AREA_NAME);
                    addControllersForAreas(kitchen);
                    AreasStorage.addHomeArea(kitchen);
                    break;
                case "2":
                    IHomeArea badRoom = new HomeArea(AreasStorage.BAD_ROOM_AREA_NAME);
                    addControllersForAreas(badRoom);
                    AreasStorage.addHomeArea(badRoom);
                    break;
                case "3":
                    IHomeArea livingRoom = new HomeArea(AreasStorage.LIVING_ROOM_AREA_NAME);
                    addControllersForAreas(livingRoom);
                    AreasStorage.addHomeArea(livingRoom);
                    break;
                case "4":
                    IHomeArea lobby = new HomeArea(AreasStorage.LOBBY_AREA_NAME);
                    addControllersForAreas(lobby);
                    AreasStorage.addHomeArea(lobby);
                    break;
                case "5":
                    IHomeArea bathroom = new HomeArea(AreasStorage.BATHROOM_AREA_NAME);
                    addControllersForAreas(bathroom);
                    AreasStorage.addHomeArea(bathroom);
                    break;
                case "6":
                    IHomeArea toilet = new HomeArea(AreasStorage.TOILET_AREA_NAME);
                    addControllersForAreas(toilet);
                    AreasStorage.addHomeArea(toilet);
                    break;
                case "q":
                    userComplete = true;
                    break;
                default:
                    ConsoleUserSettings.consolePrinter.output("\nYou input wrong type of area, please, try again!");
                    break;
            }
        }
    }

    public static void addControllersForAreas(final IHomeArea homeArea) {

        String homeAreaID = homeArea.getName();
        outputRouter.output(homeAreaID, ExternalCommands.GET_AVALIBLE_CONTROLLERS);
    }
}

