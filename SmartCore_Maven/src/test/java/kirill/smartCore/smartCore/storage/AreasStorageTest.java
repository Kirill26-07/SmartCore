package kirill.smartCore.smartCore.storage;

import org.junit.jupiter.api.Test;
import smartCore.areas.HomeArea;

class AreasStorageTest {


    @Test
    void getHomeArea() {
        HomeArea testHomeArea = new HomeArea("TestArea");
        AreasStorage.addHomeArea(testHomeArea);
        assertEquals(testHomeArea, AreasStorage.getHomeArea(0));
    }
}