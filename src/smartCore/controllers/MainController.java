package smartCore.controllers;

import arduino.Arduino;
import smartCore.controllers.serverClientInteraction.inputControllers.InputRouter;
import smartCore.controllers.serverClientInteraction.outputController.ComPortOutputRouter;

public class MainController extends AbstractController {

    protected static final Arduino smartHomeInteraction = new Arduino();
    protected static final InputRouter<String, Double> inputRouter = new InputRouter<>();
    protected static final ComPortOutputRouter comPortOutputRouter = new ComPortOutputRouter();

    @Override
    public void switchOn() {
        if (!controllerState){
            controllerState = true;
        }
    }

    @Override
    public void switchOf() {
        if(controllerState){
            controllerState = false;
        }
    }

    public static String getDevicesID(){

        comPortOutputRouter.output("GET_DEVICES_ID");
        return null;
    }
}
