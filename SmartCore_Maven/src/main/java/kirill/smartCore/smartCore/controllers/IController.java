package kirill.smartCore.smartCore.controllers;

public interface IController {

    void switchOn();

    void switchOf();

    boolean getControllerState();

    int getCONTROLLER_ID();

    void setControllerState(boolean controllerState);

}
