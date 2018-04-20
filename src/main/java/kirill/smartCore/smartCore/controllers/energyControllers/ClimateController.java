/**
 * Класс-контроллер, реализует функции по контролю и управлению климатом
 */
package kirill.smartCore.smartCore.controllers.energyControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.controllers.interactoinWithUser.settings.AreaSettings;

public class ClimateController extends AbstractController {

    public ClimateController(final int controller_id, final String area_id) {
        super(controller_id, area_id);
    }

    @Override
    public boolean inputData(final int inputValue, final AreaSettings areaPreSettings) {

        if (inputValue >= areaPreSettings.getMaxTemp()) {
            switchOn();
            return true;
        } else if (inputValue <= areaPreSettings.getMinTemp()) {
            switchOf();
            return true;
        } else {
            return false;
        }
    }
}
