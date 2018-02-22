package kirill.smartCore.smartCore.controllers;

import arduino.Arduino;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.IInputRouter;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.IOutputRouter;

public abstract class AbstractIOController implements IInputRouter, IOutputRouter{

    protected static Arduino SmartHome = new Arduino();

    @Override
    public void input(Object deviceID, Object externalInput) {

    }

    @Override
    public void output(String command) {

    }

    @Override
    public void output(String controllerID, boolean controllerState) {

    }

    @Override
    public void output(String controllerID, boolean controllerState, int value) {

    }
}
