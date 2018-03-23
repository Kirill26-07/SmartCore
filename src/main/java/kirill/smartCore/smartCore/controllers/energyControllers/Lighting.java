/**
 * Класс-контроллер, реализует функции по контролю и управлению освещением
 */
package kirill.smartCore.smartCore.controllers.energyControllers;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.model.HomeArea;

public class Lighting extends AbstractController {

    public Lighting(int controller_id) {
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
