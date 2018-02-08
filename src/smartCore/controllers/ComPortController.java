package smartCore.controllers;


import arduino.Arduino;

public class ComPortController implements IController {

    private boolean controllerState;

    private Arduino smartHome = new Arduino();

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

}
