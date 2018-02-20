package kirill.smartCore.smartCore.storage;

import kirill.smartCore.smartCore.areas.HomeArea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AreasStorageTest {


    @Test
    void getHomeArea() {
        HomeArea testHomeArea = new HomeArea("TestArea");
        AreasStorage.addHomeArea(testHomeArea);
        assertEquals(testHomeArea, AreasStorage.getHomeArea(0));
    }
}