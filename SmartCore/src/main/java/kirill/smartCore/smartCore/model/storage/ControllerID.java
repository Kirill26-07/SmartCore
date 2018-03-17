/**
 * Класс хранит ID всех созданных в системе контроллеров
 */

package kirill.smartCore.smartCore.model.storage;

public enum ControllerID {

    GASCONTROLLER_ID(0),
    LIGHTING_ID(1),
    WATERCONRTOLLER_ID(2),
    CLIMATECONTROLLER_ID(3),
    ACCESSCONTROLLER_ID(4);

    private int ID;

    ControllerID(int index){
        this.ID = index;
    }
}
