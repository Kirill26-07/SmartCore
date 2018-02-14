/**
 * Класс хранит созданных пользователей, присваевает им ID и отдаетпользовател по запросу
 */
package smartCore.storage;

import smartCore.autorithation.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserStorage implements Iterable<User>{

    private static ArrayList<User> userStorage = new ArrayList<>();
    private static Map<String, Integer> userID = new HashMap<>();
    private static int nextUserID;

    public static void saveNewUser(final User newUser){

        String userName = newUser.getUserName();
        userStorage.add(newUser);
        assignIDToUser(userName);
    }

    public static User getUser(final String userName){

        return userStorage.get(userID.get(userName));
    }

    public static ArrayList<User> getUserStorage(){

        return userStorage;
    }

    private static void assignIDToUser(final String userName){

        userID.put(userName, nextUserID);
        nextUserID ++;
    }

    @Override
    public Iterator<User> iterator() {
        return userStorage.iterator();
    }
}

