package kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers;

import kirill.smartCore.smartCore.exceptions.ConnectionFailedException;

public interface IInputRouter {

    void inputSignal() throws ConnectionFailedException;
    void restartInputConnection();

}
