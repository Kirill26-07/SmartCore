/**
 * Класс для создания пользователя который хранит:
 *
 * userName - имя пользователя,
 * userPassWord - пароль пользователя.
 *
 * A также реализует функционал авторизации пользователя и изменени пароля.
 */

package kirill.smartCore.smartCore.model;

import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.ConsoleReader;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.ConsolePrinter;
import java.util.Objects;

public class User implements Comparable<User> {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private ConsoleReader consoleReader = new ConsoleReader();

    private final String userName;
    private String userPassword;


    public User(final String name, final String password) {
        this.userName = name;
        this.userPassword = password;
    }

    public final void changePassword(final String currentUserName, final String currentUserPassword) {
        if (this.userName.equals(currentUserName) && this.userPassword.equals(currentUserPassword)) {
            consolePrinter.output("Please, input your new password: ");
            this.userPassword = consoleReader.consoleInput().trim();
        } else {
            consolePrinter.output("Incorrect user name or password!");
        }
    }

    public final String getUserName() {
        return userName;
    }

    public final String getUserPassword() {
        return userPassword;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName)
                && Objects.equals(userPassword, user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userPassword);
    }

    @Override
    public String toString() {
        return userName;
    }

    @Override
    public int compareTo(User user) {
        return this.userName.compareTo(user.getUserName());
    }
}
