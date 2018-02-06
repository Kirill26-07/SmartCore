/**
 * Данный класс предназначен для предварительной настройки системы, а также для изменения настроек
 * во время ее использования.
 * Основной функционал:
 * - Первичная настройка системы, включающая создания пользователей и создание зонированных участков дома
 * для точной их настройки под себя.
 */

package smartCore.settings;

import com.sun.jdi.InvalidTypeException;
import serverClientInteraction.inputControllers.ConsoleReader;
import serverClientInteraction.outputController.ConsolePrinter;
import smartCore.areas.HomeArea;
import smartCore.autorithation.User;
import smartCore.storage.AreasStorage;
import smartCore.storage.UserStorage;


public class UserSettings {

    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsolePrinter consolePrinter = new ConsolePrinter();

    /**
     * Метод запускающий сценариии настройки системы при первом ее запуске
     */
    public void firstSatart(){

        createNewUser();

        try {
            addNewAreas();
        }
        catch (InvalidTypeException e){
            consolePrinter.output("You input wrong type of area, please, try again!");
        }
    }

    /**
     * Метод создающий нового пользователя.
     * Запрашивает имя пользователя и пароль, после чего сохраняет их в системе.
     */
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

    /**
     * Метод добавляет в систему зоны, которые пользователь хочет использовать в своем доме для автоматизации.
     * Данный метод используется в том числе и для дальнейшего добавления зон в процессе использования системы.
     *
     * @throws InvalidTypeException - бросается при некорретном вводе пользователем типа добавляемой зоны
     */
    private void addNewAreas() throws InvalidTypeException {

        StringBuilder stringBuilder = new StringBuilder();

        consolePrinter.output(stringBuilder.append("Select the areas you want to create.")
                                            .append("\nNow we improve six types of home areas: ")
                                            .append("\n1 - Kitchen;")
                                            .append("\n2 - Bad room;")
                                            .append("\n3 - Living room;")
                                            .append("\n4 - Lobby;")
                                            .append("\n5 - Bathroom;")
                                            .append("\n6 - Toilet.")
                                            .append("\nInput numbers of types to create that areas:\n")
                                            .append("\nInput your types by entering, to complete input - Q!"));

        String userComplete = "";

        while (!userComplete.equals("Q")){

        String typesOfAreas = consoleReader.consoleInput();

            switch (typesOfAreas) {
                case "1":
                    HomeArea kitchen = new HomeArea("Kitchen");
                    AreasStorage.addHomeArea(kitchen);
                    break;
                case "2":
                    HomeArea badRoom = new HomeArea("Bad room");
                    AreasStorage.addHomeArea(badRoom);
                    break;
                case "3":
                    HomeArea livingRoom = new HomeArea("Living room");
                    AreasStorage.addHomeArea(livingRoom);
                    break;
                case "4":
                    HomeArea lobby = new HomeArea("Lobby");
                    AreasStorage.addHomeArea(lobby);
                    break;
                case "5":
                    HomeArea bathroom = new HomeArea("Bathroom");
                    AreasStorage.addHomeArea(bathroom);
                    break;
                case "6":
                    HomeArea toilet = new HomeArea("Toilet");
                    AreasStorage.addHomeArea(toilet);
                    break;
                case "Q":
                    userComplete = "Q";
                    break;
                default:
                    throw new InvalidTypeException();
            }

        }

    }

}
