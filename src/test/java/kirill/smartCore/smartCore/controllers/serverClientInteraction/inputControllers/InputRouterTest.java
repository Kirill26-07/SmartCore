package kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers;

import kirill.smartCore.smartCore.exceptions.ConnectionFailedException;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class InputRouterTest extends InputRouter {

    private byte homeAreaID;
    private byte controllerID;
    private byte sensorSignal;

    @Test
    void testInputSignal() {

    }

    @Test
    void testRestartInputConnection() {
    }

    @Override
    public void inputSignal() throws ConnectionFailedException {
        super.inputSignal();

    }
}