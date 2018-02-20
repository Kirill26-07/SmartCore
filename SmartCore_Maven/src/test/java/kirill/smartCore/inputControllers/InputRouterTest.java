package kirill.smartCore.inputControllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InputRouterTest {

    @Test
    void input() {

        String deviceID = "kitchenSensor";
        Integer externalSensorSignal = 1;

        InputRouter<String, Integer> integerInputRouter = new InputRouter<>();
        integerInputRouter.input(deviceID, externalSensorSignal);

        assertEquals(deviceID, integerInputRouter.getDeviceID());
        assertEquals(externalSensorSignal, integerInputRouter.getSensorSignal());
    }
}