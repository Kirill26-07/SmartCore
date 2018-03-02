package kirill.smartCore.smartCore.model.storage;

import kirill.smartCore.smartCore.model.HomeArea;
import kirill.smartCore.smartCore.model.IHomeArea;
import kirill.smartCore.smartCore.model.storage.AreasStorage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AreasStorageTest {

    private static String testAreaName = "Kitchen";
    private static int testAreaID = 0;

    @Test
    void getHomeArea() {
        IHomeArea testHomeArea = new HomeArea(testAreaName, testAreaID);
        AreasStorage.addHomeArea(testHomeArea);
        assertEquals(testHomeArea, AreasStorage.getHomeArea(0));
    }
}