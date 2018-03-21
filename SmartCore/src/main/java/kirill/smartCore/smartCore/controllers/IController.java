package kirill.smartCore.smartCore.controllers;

import kirill.smartCore.smartCore.model.HomeArea;

public interface IController {

    byte getControllerState();
    void setControllerState(byte controllerState);
    void switchOn();
    void switchOf();
    int getCONTROLLER_ID();
    void inputData(byte inputValue, HomeArea.AreaPreSettings areaPreSettings);

}
