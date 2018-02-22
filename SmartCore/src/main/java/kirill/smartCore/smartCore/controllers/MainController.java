/**
 * Класс реализует основные методы используемые всеми контроллерами наследующими его
 */

package kirill.smartCore.smartCore.controllers;

import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.ComPortOutputRouter;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.InputRouter;

public class MainController extends AbstractController {

    protected static final InputRouter<String, Double> inputRouter = new InputRouter<>();
    protected static final ComPortOutputRouter comPortOutputRouter = new ComPortOutputRouter();

    public MainController(int controller_id) {
        super(controller_id);
    }

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
