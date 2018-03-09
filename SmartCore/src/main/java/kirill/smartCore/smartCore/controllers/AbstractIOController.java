package kirill.smartCore.smartCore.controllers;

import com.arduinoSerialJ.Arduino;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.IInputRouter;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.IOutputRouter;


public abstract class AbstractIOController implements IInputRouter, IOutputRouter{

    private static final String SERIAL_PORT = "/dev/cu.usbmodem1411";
    private static final int SERIAL_SPEED = 9600;

    protected static Arduino smartHome = new Arduino(SERIAL_PORT, SERIAL_SPEED);


    @Override
    public void input(final Object deviceID, final Object externalInput) {

    }

    @Override
    public void output(final String command) {

    }

    @Override
    public void output(final String controllerID, final boolean controllerState) {

    }

    @Override
    public void output(final String controllerID, final boolean controllerState, final int value) {

    }

}
