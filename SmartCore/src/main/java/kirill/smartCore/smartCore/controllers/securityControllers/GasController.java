/**
 * Класс-контроллер, реализует функции по контролю и управлению газовым оборудованием
 */
package kirill.smartCore.smartCore.controllers.securityControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.model.HomeArea;

public class GasController extends AbstractController {

    public GasController(int controller_id) {
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
