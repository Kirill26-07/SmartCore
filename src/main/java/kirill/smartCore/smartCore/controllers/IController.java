package kirill.smartCore.smartCore.controllers;


import kirill.smartCore.smartCore.controllers.interactoinWithUser.settings.AreaSettings;

public interface IController {
    void switchOn();
    void switchOf();
    boolean inputData(final int inputValue, final AreaSettings areaPreSettings);
}
