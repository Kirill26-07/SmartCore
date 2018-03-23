package kirill.smartCore.smartCore.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private String testUserName = "Kirill";
    private String testUserPassword = "123!qaZ";
    private String newPassword = "8080rfvhu";

    private User testUser = new User(testUserName, testUserPassword);

    @Test
    void getUserName() {
        assertEquals(testUserName, testUser.getUserName());
    }

    @Test
    void getUserPassword() {
        assertEquals(testUserPassword, testUser.getUserPassword());
    }
}