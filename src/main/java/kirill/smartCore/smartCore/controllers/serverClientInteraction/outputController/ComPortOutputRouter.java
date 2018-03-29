/**
 * Класс реализующий Output данных через Serial port
 */

package kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController;

import kirill.smartCore.smartCore.controllers.AbstractIOController;
import kirill.smartCore.smartCore.model.storage.ExternalCommands;

public class ComPortOutputRouter extends AbstractIOController {


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
