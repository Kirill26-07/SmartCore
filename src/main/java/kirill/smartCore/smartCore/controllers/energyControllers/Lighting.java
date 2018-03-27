/**
 * Класс-контроллер, реализует функции по контролю и управлению освещением
 */
package kirill.smartCore.smartCore.controllers.energyControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.model.HomeArea;

public class Lighting extends AbstractController {

    private static final byte LIGHTING_ON = 1;
    private static final byte LIGHTING_OFF = 0;

    public Lighting(int controller_id, String area_id) {
        super(controller_id, area_id);
    }

    @Override
    public void inputData(byte inputValue, HomeArea.AreaPreSettings areaPreSettings) {
        if(inputValue == LIGHTING_ON && controllerState == LIGHTING_OFF){
            controllerState = controllerStates.ON.getState();
            switchOn();
            // Далее необходимо запустить таймер со временем из пресетингов и если с момента последнего
            // сигнала прошло время указанное в персетинге - switchOff();
        }
    }
}
