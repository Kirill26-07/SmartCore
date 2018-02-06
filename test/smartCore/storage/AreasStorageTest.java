package smartCore.storage;

import org.junit.jupiter.api.Test;
import smartCore.areas.HomeArea;

import static org.junit.jupiter.api.Assertions.*;

class AreasStorageTest {


    @Test
    void getHomeArea() {
        HomeArea testHomeArea = new HomeArea("TestArea");
        AreasStorage.addHomeArea(testHomeArea);
        assertEquals(testHomeArea, AreasStorage.getHomeArea(0));
    }
}