/**
 * Класс-контроллер, реализует функции по контролю и управлению газовым оборудованием
 */
package kirill.smartCore.smartCore.controllers.securityControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.model.HomeArea;

public class GasController extends AbstractController {

    private static final byte ALARM = 9;

    public GasController(final int controller_id, final String area_id) {
        super(controller_id, area_id);
    }

    @Override
    public void inputData(final byte inputValue, final HomeArea.AreaPreSettings areaPreSettings) {
        if(inputValue == ALARM){
            switchOf();
        }
    }
}
