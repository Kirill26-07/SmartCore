/**
 * Класс-контроллер, реализует функции по контролю и управлению системой базопасности
 */
package kirill.smartCore.smartCore.controllers.securityControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.model.HomeArea;

public class AccessController extends AbstractController {

    public AccessController(int controller_id) {
        super(controller_id);
    }

    @Override
    public void inputData(byte inputValue, HomeArea.AreaPreSettings areaPreSettings) {

    }

    @Override
    public void switchOn() {

    }

    @Override
    public void switchOf() {

    }

}
