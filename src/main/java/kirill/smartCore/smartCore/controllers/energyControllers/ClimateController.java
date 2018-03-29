/**
 * Класс-контроллер, реализует функции по контролю и управлению климатом
 */
package kirill.smartCore.smartCore.controllers.energyControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.model.HomeArea;

public class ClimateController extends AbstractController {

    public ClimateController(final int controller_id, final String area_id) {
        super(controller_id, area_id);
    }

    @Override
    public void inputData(final byte inputValue, final HomeArea.AreaPreSettings areaPreSettings) {

        if(inputValue >= areaPreSettings.getMAX_TEMP()){
            switchOn();
        }
        if(inputValue <= areaPreSettings.getMIN_TEMP()){
            switchOf();
        }
    }

}
