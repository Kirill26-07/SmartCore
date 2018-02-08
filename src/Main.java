import smartCore.settings.ConsoleUserSettings;

public class Main {

    public static void main(String[] args) {

       firstStart();

    }

    private static void firstStart(){

        ConsoleUserSettings.createNewUser();
        ConsoleUserSettings.addNewAreas();
    }
}