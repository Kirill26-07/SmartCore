package smartCore.autorithation;

import serverClientInteraction.inputControllers.ConsoleReader;
import serverClientInteraction.outputController.ConsolePrinter;

public class User {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private ConsoleReader consoleReader = new ConsoleReader();

    private final String userName;
    private String userPassword;


    public User(String userName, String userPassword){

        this.userName = userName;
        this.userPassword = userPassword;

    }

    public boolean userAutorization(final String userName, final String userPassword){

        return this.userName.equals(userName) && this.userPassword.equals(userPassword);

    }

    public boolean changePassword(final String userName, final String currentUserPassword){

        if(this.userName.equals(userName) && this.userPassword.equals(currentUserPassword)){

            consolePrinter.output("Please, input your new password: ");
            this.userPassword = consoleReader.consoleInput();
            return true;
        }
        else {

            consolePrinter.output("Incorrect user name or password");
            return false;
        }

    }

    public String getUserName() {
        return userName;
    }

}
