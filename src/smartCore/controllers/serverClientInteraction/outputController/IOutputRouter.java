package smartCore.controllers.serverClientInteraction.outputController;

public interface IOutputRouter {

    void output(String command);
    void output(String controllerID, boolean controllerState);
    void output(String controllerID, boolean controllerState, int value);
}
