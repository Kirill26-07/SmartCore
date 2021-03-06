/**
 * Класс-контроллер, реализует функции по контролю и управлению системой базопасности
 */
package kirill.smartCore.smartCore.controllers.securityControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.controllers.interactoinWithUser.settings.AreaSettings;

public class AccessController extends AbstractController implements IAlarming {

    public AccessController(final int controller_id, final String area_id) {
        super(controller_id, area_id);
    }

    @Override
    public boolean inputData(final int inputValue, final AreaSettings areaPreSettings) {
        return true;
    }

    @Override
    public void alarm() {
        System.out.println("Unauthorized access"); // for testing
    }
}
