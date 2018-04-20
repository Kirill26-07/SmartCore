package kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController;

import kirill.smartCore.smartCore.model.storage.ExternalCommands;

public interface IOutputRouter {
    void output(final ExternalCommands command);
    void output(final String areaID, final ExternalCommands command);
    void output(final String areaID, final int controllerID, ExternalCommands command);
}
