package smartCore.controllers;


import arduino.Arduino;

public abstract class AbstractComPortController implements IController {

    private boolean controllerState;
    private final int CONTROLLER_ID;

    private Arduino smartHome = new Arduino();

    protected AbstractComPortController(int controller_id) {
        CONTROLLER_ID = controller_id;
    }

    @Override
    public void switchOn(){


    }

    @Override
    public void switchOf(){


    }

    @Override
    public boolean getControllerState(){
        return controllerState;
    }

    @Override
    public int getCONTROLLER_ID() {
        return CONTROLLER_ID;
    }
}
