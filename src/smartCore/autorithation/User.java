/**
 * Класс для создания пользователя который хранит:
 *
 * userName - имя пользователя,
 * userPassWord - пароль пользователя.
 *
 * а также реализует функционал авторизации пользователя и изменени пароля.
 */

package smartCore.autorithation;

import smartCore.controllers.serverClientInteraction.inputControllers.ConsoleReader;
import smartCore.controllers.serverClientInteraction.outputController.ConsolePrinter;

import java.util.Objects;

public class User {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private ConsoleReader consoleReader = new ConsoleReader();

    private final String userName;
    private String userPassword;


    public User(final String userName, final String userPassword){

        this.userName = userName;
        this.userPassword = userPassword;

    }

    public boolean userAuthorization(final String userName, final String userPassword){

        return this.userName.equals(userName) && this.userPassword.equals(userPassword);

    }

    public boolean changePassword(final String userName, final String currentUserPassword){

        if(this.userName.equals(userName) && this.userPassword.equals(currentUserPassword)){

            consolePrinter.output("Please, input your new password: ");
            this.userPassword = consoleReader.consoleInput().trim();
            return true;
        }
        else {

            consolePrinter.output("Incorrect user name or password!");
            return false;
        }

    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(userPassword, user.userPassword);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, userPassword);
    }
}
