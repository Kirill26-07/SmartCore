package kirill.smartCore.smartCore.model.storage;

import kirill.smartCore.smartCore.model.HomeArea;
import kirill.smartCore.smartCore.model.IHomeArea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreasStorageTest {

    private String areaName = AreasStorage.AreaName.KITCHEN.getName();
    private IHomeArea testArea = new HomeArea(areaName);

    @Test
    void testHomeArea() {
        AreasStorage.addHomeArea(testArea);
        assertEquals(testArea, AreasStorage.getHomeArea(areaName));

        assertFalse(AreasStorage.addHomeArea(testArea));
    }

}