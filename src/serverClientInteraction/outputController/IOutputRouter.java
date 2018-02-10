package serverClientInteraction.outputController;

public interface IOutputRouter {

    void output(boolean controllerState);
    void output(int value);

}
