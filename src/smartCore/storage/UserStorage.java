package smartCore.storage;

import smartCore.autorithation.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private static ArrayList<User> userStorage = new ArrayList<>();
    private static Map<String, Integer> userID = new HashMap<>();
    private static int nextUserID;

    public static void saveNewUser(User newUser){

        String userName = newUser.getUserName();
        userStorage.add(newUser);
        assignIDToUser(userName);
    }

    public static User getUser(int userID){

       return userStorage.get(userID);

    }

    public static int getUserID(String userName){

        return userID.get(userName);

    }

    private static void assignIDToUser(String userName){

        userID.put(userName, nextUserID);
        nextUserID ++;
    }


}

