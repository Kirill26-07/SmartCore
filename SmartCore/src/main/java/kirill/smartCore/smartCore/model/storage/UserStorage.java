/**
 * Класс хранит созданных пользователей, присваевает им ID и отдает пользователя по запросу.
 * User ID - в качестве данного параметра используется ися пользователя под которым он регистрируется в системе.
 * Имя пользователя должно быть уникальным.
 */
package kirill.smartCore.smartCore.model.storage;

import kirill.smartCore.smartCore.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private static Map<String, User> userStorage = new HashMap<>();

    public static void saveNewUser(final User newUser) {

        String userName = newUser.getUserName();
        userStorage.put(userName, newUser);
    }

    public static User getUser(final String userName) {

        return userStorage.get(userName);
    }

    public static Map<String, User> getUserStorage() {

        return userStorage;
    }
}
