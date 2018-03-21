package kirill.smartCore.smartCore.model;

import kirill.smartCore.smartCore.controllers.energyControllers.ClimateController;
import kirill.smartCore.smartCore.controllers.energyControllers.Lighting;
import kirill.smartCore.smartCore.controllers.securityControllers.AccessController;
import kirill.smartCore.smartCore.controllers.securityControllers.GasController;
import kirill.smartCore.smartCore.controllers.securityControllers.WaterController;
import kirill.smartCore.smartCore.model.storage.AreasStorage;
import kirill.smartCore.smartCore.model.storage.ControllerID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeAreaTest {

    private IHomeArea testHomeArea = new HomeArea(AreasStorage.BATHROOM_AREA_NAME);

    @Test
    void setLightingController() {
        Lighting testLighting = new Lighting(ControllerID.LIGHTING_ID);
        testHomeArea.setLightingController(testLighting);
        assertNotNull(testHomeArea.getLightingController());
    }

    @Test
    void setGasController() {
        GasController testGasController = new GasController(ControllerID.GAS_CONTROLLER_ID);
        testHomeArea.setGasController(testGasController);
        assertNotNull(testHomeArea.getGasController());
    }

    @Test
    void setWaterController() {
        WaterController testWaterController = new WaterController(ControllerID.WATER_CONTROLLER_ID);
        testHomeArea.setWaterController(testWaterController);
        assertNotNull(testHomeArea.getWaterController());
    }

    @Test
    void setAccessController() {
        AccessController testAccessController = new AccessController(ControllerID.ACCESS_CONTROLLER_ID);
        testHomeArea.setAccessController(testAccessController);
        assertNotNull(testHomeArea.getAccessController());

    }

    @Test
    void setClimateController() {
        ClimateController testClimateController = new ClimateController(ControllerID.CLIMATE_CONTROLLER_ID);
        testHomeArea.setClimateController(testClimateController);
        assertNotNull(testHomeArea.getClimateController());
    }

    @Test
    void getName() {
        String homeAreaName = "Bathroom";
        assertEquals(homeAreaName, testHomeArea.getName());
    }
}