/**
 * Абстрактный клас для контроллеров отвечающих за Input/Output данных.
 * Включает в себя базовые поля и классы
 */

package kirill.smartCore.smartCore.controllers;

import com.arduinoSerialJ.Arduino;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.IInputRouter;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.IOutputRouter;
import kirill.smartCore.smartCore.model.storage.ExternalCommands;


public abstract class AbstractIOController implements IInputRouter, IOutputRouter{

    private static final String SERIAL_PORT = "/dev/cu.usbmodem1411";
    private static final int SERIAL_SPEED = 9600;

    protected static Arduino smartHome = new Arduino(SERIAL_PORT, SERIAL_SPEED);

    @Override
    public void input(Object deviceID, Object externalInput) {

    }

    @Override
    public void output(ExternalCommands command) {

    }

    @Override
    public void output(String areaID, ExternalCommands command) {

    }

    @Override
    public void output(String areaID, int controllerID, ExternalCommands command) {

    }
}
