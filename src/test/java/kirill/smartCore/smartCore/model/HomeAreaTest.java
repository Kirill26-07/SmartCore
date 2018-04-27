package kirill.smartCore.smartCore.model;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.controllers.energyControllers.ClimateController;
import kirill.smartCore.smartCore.controllers.energyControllers.Lighting;
import kirill.smartCore.smartCore.model.storage.ControllerID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeAreaTest {

    private final String AREA_NAME = "Test Area";
    private final int lightingID = ControllerID.LIGHTING_ID.getID();
    private final int climateControllerID  = ControllerID.CLIMATE_CONTROLLER_ID.getID();
    private final int INPUT_SIGNAL = 0;
    private final int INPUT_SIGNAL_1 = 1;

    private IHomeArea<AbstractController> testArea;
    private Lighting testLighting = new Lighting(lightingID, AREA_NAME);
    private ClimateController testClimateController = new ClimateController(climateControllerID, AREA_NAME);

    @BeforeEach
    void setAreaControllers() {
        testArea = new HomeArea<>(AREA_NAME);
        testArea.setAreaControllers(lightingID, testLighting);
        testArea.setAreaControllers(climateControllerID, testClimateController);
    }

    // This test need some code changes!
    @Test
    void inputData() {
        assertFalse(testArea.inputData(lightingID, INPUT_SIGNAL));
        assertTrue(testArea.inputData(lightingID, INPUT_SIGNAL_1));

    }

    @Test
    void getName() {
        assertEquals(AREA_NAME, testArea.getName());
    }
}