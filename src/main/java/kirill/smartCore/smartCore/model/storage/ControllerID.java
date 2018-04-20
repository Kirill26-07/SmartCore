/**
 * Класс хранит ID всех созданных в системе контроллеров
 */

package kirill.smartCore.smartCore.model.storage;

public enum ControllerID {

    GAS_CONTROLLER_ID(0),
    LIGHTING_ID(1),
    WATER_CONTROLLER_ID(2),
    CLIMATE_CONTROLLER_ID(3),
    ACCESS_CONTROLLER_ID(4);

    private int ID;

    ControllerID(final int index) {
        this.ID = index;
    }

    public int getID() {
        return ID;
    }
}
