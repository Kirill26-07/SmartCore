package kirill.smartCore.smartCore.model.storage;

import kirill.smartCore.smartCore.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserStorageTest {

    private String testUserName = "Kirill";
    private String testUserPassword = "123QAZ";
    private String invalidUser = "TestUser";
    private User testUser = new User(testUserName, testUserPassword);

    @BeforeEach
    void addTestUser() {
        UserStorage.saveNewUser(testUser);
    }

    @Test
    void saveNewUser() {
        assertFalse(UserStorage.getUserStorage().isEmpty());

        UserStorage.getUserStorage().clear();
        assertTrue(UserStorage.getUserStorage().isEmpty());
    }

    @Test
    void getUser() {
        User newTestUser = UserStorage.getUser(testUserName);

        assertEquals(testUserName, newTestUser.getUserName());
        assertEquals(testUserPassword, newTestUser.getUserPassword());

        newTestUser = UserStorage.getUser(invalidUser);
        assertEquals("NOT FOUND", newTestUser.toString());
    }
}