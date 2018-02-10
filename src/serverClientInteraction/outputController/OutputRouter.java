package serverClientInteraction.outputController;

import arduino.Arduino;

public class OutputRouter implements IOutputRouter {

    private Arduino smartHome = new Arduino();

    @Override
    public void output(boolean controllerState) {


    }

    @Override
    public void output(int value) {

    }
}
