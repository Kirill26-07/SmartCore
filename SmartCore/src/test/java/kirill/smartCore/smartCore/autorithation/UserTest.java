package kirill.smartCore.smartCore.autorithation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {

    private String userName = "Kirill";
    private String userPassword = "123Wf*";

    private User testUser = new User(userName, userPassword);

    @Test
    void userAuthorization() {

      assertTrue(testUser.userAuthorization(userName, userPassword));

    }

    @Test
    void getUserName() {

        assertEquals(userName, testUser.getUserName());
    }
}