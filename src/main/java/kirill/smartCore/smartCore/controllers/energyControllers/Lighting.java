/**
 * Класс-контроллер, реализует функции по контролю и управлению освещением
 */
package kirill.smartCore.smartCore.controllers.energyControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.controllers.interactoinWithUser.settings.AreaSettings;


public class Lighting extends AbstractController {

    private static final int LIGHTING_ON = 1;
    private static final int LIGHTING_OFF = 0;

    public Lighting(final int controller_id, final String area_id) {
        super(controller_id, area_id);
    }

    @Override
    public boolean inputData(final int inputValue, final AreaSettings areaPreSettings) {
        if (inputValue == LIGHTING_ON && controllerState == LIGHTING_OFF) {
            controllerState = controllerStates.ON.getState();
            return true;
//            switchOn();
// Далее необходимо запустить таймер со временем из пресетингов и если с момента последнего
// сигнала прошло время указанное в персетинге - switchOff();
        } else {
            return false;
        }
    }
}
