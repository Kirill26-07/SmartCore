package kirill.smartCore.smartCore.controllers;

import kirill.smartCore.smartCore.model.HomeArea;

public interface IController {

    void switchOn();
    void switchOf();
    void inputData(byte inputValue, HomeArea.AreaPreSettings areaPreSettings);

}
