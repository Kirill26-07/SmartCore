/**
 * Класс-контроллер, реализует функции по контролю и управлению системой базопасности
 */
package kirill.smartCore.smartCore.controllers.securityControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.model.HomeArea;

public class AccessController extends AbstractController {

    public AccessController(final int controller_id, final String area_id) {
        super(controller_id, area_id);
    }

    @Override
    public boolean inputData(final int inputValue, final HomeArea.AreaPreSettings areaPreSettings) {
        return true;
    }
}
