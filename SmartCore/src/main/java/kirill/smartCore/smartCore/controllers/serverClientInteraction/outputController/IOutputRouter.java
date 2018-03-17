package kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController;

import kirill.smartCore.smartCore.model.storage.ExternalCommands;

public interface IOutputRouter {

    void output(ExternalCommands command);
    void output(String areaID, ExternalCommands command);
    void output(String areaID, String controllerID, ExternalCommands command);
}
