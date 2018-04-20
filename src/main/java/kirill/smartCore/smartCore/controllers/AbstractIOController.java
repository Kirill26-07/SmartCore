/**
 * Абстрактный клас для контроллеров отвечающих за Input/Output данных.
 * Включает в себя базовые поля и классы
 */

package kirill.smartCore.smartCore.controllers;

import com.arduinoSerialJ.Arduino;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers.IInputRouter;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.IOutputRouter;
import kirill.smartCore.smartCore.model.storage.ExternalCommands;


public abstract class AbstractIOController implements IOutputRouter {

    private static final String SERIAL_PORT = "/dev/cu.usbmodem1411";
    private static final int SERIAL_SPEED = 9600;

    protected static Arduino smartHome = new Arduino(SERIAL_PORT, SERIAL_SPEED);

    @Override
    public void output(final ExternalCommands command) {

    }

    @Override
    public void output(final String areaID, final ExternalCommands command) {

    }

    @Override
    public void output(final String areaID, final int controllerID, ExternalCommands command) {

    }
}
