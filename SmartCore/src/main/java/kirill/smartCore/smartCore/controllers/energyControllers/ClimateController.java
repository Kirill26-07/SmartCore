/**
 * Класс-контроллер, реализует функции по контролю и управлению климатом
 */
package kirill.smartCore.smartCore.controllers.energyControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.model.HomeArea;

public class ClimateController extends AbstractController {

    public ClimateController(int controller_id) {
        super(controller_id);
    }

    @Override
    public void inputData(byte inputValue, HomeArea.AreaPreSettings areaPreSettings) {

        if(inputValue >= areaPreSettings.getMAX_TEMP()){
            switchOn();
        }
        if(inputValue <= areaPreSettings.getMIN_TEMP()){
            switchOf();
        }
    }

    @Override
    public void switchOn() {

    }

    @Override
    public void switchOf() {

    }
}
