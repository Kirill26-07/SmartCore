/**
 * Данный класс предназначен для предварительной настройки системы, а также для изменения настроек
 * во время ее использования.
 * Основной функционал:
 * - Первичная настройка системы, включающая создания пользователей и создание зонированных участков дома
 * для точной их настройки под себя.
 */

package smartCore.interactoinWithUser.settings;

import serverClientInteraction.inputControllers.ConsoleReader;
import serverClientInteraction.outputController.ConsolePrinter;
import smartCore.areas.HomeArea;
import smartCore.autorithation.User;
import smartCore.controllers.energyControllers.ClimateController;
import smartCore.controllers.energyControllers.Lighting;
import smartCore.controllers.securityControllers.AccessController;
import smartCore.controllers.securityControllers.GasController;
import smartCore.controllers.securityControllers.WaterController;
import smartCore.storage.AreasStorage;
import smartCore.storage.UserStorage;


public class ConsoleUserSettings {

    private static ConsoleReader consoleReader = new ConsoleReader();
    private static ConsolePrinter consolePrinter = new ConsolePrinter();

    public static void createNewUser(){

        ConsoleUserSettings.consolePrinter.output("\nInput your name: ");
        String name = ConsoleUserSettings.consoleReader.consoleInput().trim();


        boolean passwordConfirm = false;
        do {
            ConsoleUserSettings.consolePrinter.output("\nInput your password");
            String password = ConsoleUserSettings.consoleReader.consoleInput().trim();

            ConsoleUserSettings.consolePrinter.output("\nConfirm your password");
            String confirmPassword = ConsoleUserSettings.consoleReader.consoleInput().trim();

            if(password.equals(confirmPassword)){
                User user_1 = new User(name, password);
                UserStorage.saveNewUser(user_1);
                passwordConfirm = true;
            }
            else {
                ConsoleUserSettings.consolePrinter.output("\nYou input wrong password, please try again");
            }
        }
        while (!passwordConfirm);

    }

    public static void addNewAreas() {

        StringBuilder stringBuilder = new StringBuilder();

        ConsoleUserSettings.consolePrinter.output(stringBuilder.append("\nSelect the areas you want to create.")
                .append("\nNow we improve six types of home areas: ")
                .append("\n1 - Kitchen;")
                .append("\n2 - Bad room;")
                .append("\n3 - Living room;")
                .append("\n4 - Lobby;")
                .append("\n5 - Bathroom;")
                .append("\n6 - Toilet.\n")
                .append("\nInput numbers of types to create that areas:\n")
                .append("\nInput your types by entering, to complete input - Q!"));

        String userComplete = "";

        while (!userComplete.equals("q")){

            String typesOfAreas = ConsoleUserSettings.consoleReader.consoleInput().toLowerCase();

            switch (typesOfAreas) {
                case "1":
                    HomeArea kitchen = new HomeArea("Kitchen");
                    addControllersForAreas(kitchen);
                    AreasStorage.addHomeArea(kitchen);
                    break;
                case "2":
                    HomeArea badRoom = new HomeArea("Bad room");
                    addControllersForAreas(badRoom);
                    AreasStorage.addHomeArea(badRoom);
                    break;
                case "3":
                    HomeArea livingRoom = new HomeArea("Living room");
                    addControllersForAreas(livingRoom);
                    AreasStorage.addHomeArea(livingRoom);
                    break;
                case "4":
                    HomeArea lobby = new HomeArea("Lobby");
                    addControllersForAreas(lobby);
                    AreasStorage.addHomeArea(lobby);
                    break;
                case "5":
                    HomeArea bathroom = new HomeArea("Bathroom");
                    addControllersForAreas(bathroom);
                    AreasStorage.addHomeArea(bathroom);
                    break;
                case "6":
                    HomeArea toilet = new HomeArea("Toilet");
                    addControllersForAreas(toilet);
                    AreasStorage.addHomeArea(toilet);
                    break;
                case "q":
                    userComplete = "q";
                    break;
                default:
                    ConsoleUserSettings.consolePrinter.output("\nYou input wrong type of area, please, try again!");
                    break;
            }
        }
    }

   public static void addControllersForAreas(HomeArea homeArea){

        StringBuilder stringBuilder = new StringBuilder();

        ConsoleUserSettings.consolePrinter.output(stringBuilder.append("\nPlease input what kind of controller do you want to add in this area:")
                .append("\n1 - Gas control system;")
                .append("\n2 - Lighting control system;")
                .append("\n3 - Water control system;")
                .append("\n4 - Climate control system;")
                .append("\n5 - Security control system.")
                .append("\nInput your types by entering, to complete input - Q!"));

        String userComplete = "";

        while (!userComplete.equals("q")){

            String controlSystems = ConsoleUserSettings.consoleReader.consoleInput().toLowerCase();

            switch (controlSystems){
                case "1":
                    GasController gasController = new GasController();
                    homeArea.setGasController(gasController);
                    break;
                case "2":
                    Lighting lightingController = new Lighting();
                    homeArea.setLightingController(lightingController);
                    break;
                case "3":
                    WaterController waterController = new WaterController();
                    homeArea.setWaterController(waterController);
                    break;
                case "4":
                    ClimateController climateController = new ClimateController();
                    homeArea.setClimateController(climateController);
                    break;
                case "5":
                    AccessController accessController = new AccessController();
                    homeArea.setAccessController(accessController);
                    break;
                case "q":
                    userComplete = "q";
                    break;
                default:
                    ConsoleUserSettings.consolePrinter.output("\nYou input wrong controller, please, try again!");
                    break;
            }
        }
    }
}

