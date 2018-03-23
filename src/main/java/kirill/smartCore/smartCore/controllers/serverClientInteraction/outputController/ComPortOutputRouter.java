/**
 * Класс реализующий Output данных через Serial port
 */

package kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController;

import kirill.smartCore.smartCore.controllers.AbstractIOController;
import kirill.smartCore.smartCore.model.storage.ExternalCommands;

public class ComPortOutputRouter extends AbstractIOController {


    @Override
    public void output(ExternalCommands command) {

    }

    @Override
    public void output(String areaID, ExternalCommands command) {

    }

    @Override
    public void output(String areaID, String controllerID, ExternalCommands command) {

    }
}
