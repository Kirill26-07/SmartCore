package kirill.smartCore.smartCore.storage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import smartCore.autorithation.User;

class UserStorageTest {

    private static String userName = "Kirill";
    private static String userPassword = "123456";
    private static final int idOfFirstUser = 0;

    @BeforeAll
    static void createTestUser(){
        User testUser = new User(userName, userPassword);
        UserStorage.saveNewUser(testUser);
    }

    @Test
    void getUser() {

        assertEquals(userName, UserStorage.getUser(userName).getUserName());
        assertEquals(userPassword, UserStorage.getUser(userName).getUserPassword());

    }

//    @Test
//    void getUserID() {
//        createTestUser();
//
//
//    }
}