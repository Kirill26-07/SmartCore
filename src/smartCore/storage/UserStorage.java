/**
 * Класс хранит созданных пользователей.
 */
package smartCore.storage;

import smartCore.autorithation.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private static ArrayList<User> userStorage = new ArrayList<>();
    private static Map<String, Integer> userID = new HashMap<>();
    private static int nextUserID;

    /**
     * Метод принимает созданного пользователя и сохраняет его в системе.
     *
     * @param newUser - принимает созданного пользователя типа User
     */

    public static void saveNewUser(User newUser){

        String userName = newUser.getUserName();
        userStorage.add(newUser);
        assignIDToUser(userName);
    }

    /**
     * Метод принимает ID пользователя и возвращает его из списка
     *
     * @param userID - принимает идентификатор пользователя.
     * @return - возвращает запрошенного пользователя
     */

    public static User getUser(int userID){

       return userStorage.get(userID);
    }

    /**
     * Метод возвращает ID пользователя по его имени
     *
     * @param userName - принимает имя пользователя
     * @return - возвращает ID пользователя
     */

    public static int getUserID(String userName){

        return userID.get(userName);
    }

    /**
     * Метод присваевает ID пользователям
     *
     * @param userName - принимает имя пользователя
     */

    private static void assignIDToUser(String userName){

        userID.put(userName, nextUserID);
        nextUserID ++;
    }
}

