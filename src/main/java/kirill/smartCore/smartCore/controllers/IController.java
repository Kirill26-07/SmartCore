package kirill.smartCore.smartCore.controllers;

import kirill.smartCore.smartCore.model.HomeArea;

public interface IController {

    void switchOn();
    void switchOf();
    boolean inputData(int inputValue, HomeArea.AreaPreSettings areaPreSettings);

}
