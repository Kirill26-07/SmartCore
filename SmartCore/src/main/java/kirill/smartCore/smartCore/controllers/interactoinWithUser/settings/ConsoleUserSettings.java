/**
 * Данный класс предназначен для предварительной настройки системы, а также для изменения настроек
 * во время ее использования.
 * Основной функционал:
 * - Первичная настройка системы, включающая создания пользователей и создание зонированных участков дома
 * для точной их настройки под себя.
 */

package kirill.smartCore.smartCore.controllers.interactoinWithUser.settings;

import kirill.smartCore.smartCore.model.IHomeArea;
import kirill.smartCore.smartCore.model.storage.ControllerID;
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

        ConsoleUserSettings.consolePrinter.output(stringBuilder.append("\nSelect the model you want to create.")
                .append("\nNow we improve six types of home model: ")
                .append("\n1 - Kitchen;")
                .append("\n2 - Bad room;")
                .append("\n3 - Living room;")
                .append("\n4 - Lobby;")
                .append("\n5 - Bathroom;")
                .append("\n6 - Toilet.\n")
                .append("\nInput numbers of types to create that model:\n")
                .append("\nInput your types by entering, to complete input - Q!"));

        String userComplete = "";

        while (!userComplete.equals("q")){

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
                    userComplete = "q";
                    break;
                default:
                    ConsoleUserSettings.consolePrinter.output("\nYou input wrong type of area, please, try again!");
                    break;
            }
        }
    }

   public static void addControllersForAreas(final IHomeArea homeArea){

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
                    GasController gasController = new GasController(ControllerID.GASCONTROLLER_ID);
                    homeArea.setGasController(gasController);
                    break;
                case "2":
                    Lighting lightingController = new Lighting(ControllerID.LIGHTING_ID);
                    homeArea.setLightingController(lightingController);
                    break;
                case "3":
                    WaterController waterController = new WaterController(ControllerID.WATERCONRTOLLER_ID);
                    homeArea.setWaterController(waterController);
                    break;
                case "4":
                    ClimateController climateController = new ClimateController(ControllerID.CLIMATECONTROLLER_ID);
                    homeArea.setClimateController(climateController);
                    break;
                case "5":
                    AccessController accessController = new AccessController(ControllerID.ACCESSCONTROLLER_ID);
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

