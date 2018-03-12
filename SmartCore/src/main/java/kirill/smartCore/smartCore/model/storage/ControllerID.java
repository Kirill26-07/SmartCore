/**
 * Класс хранит ID всех созданных в системе контроллеров
 */

package kirill.smartCore.smartCore.model.storage;

import java.util.HashMap;
import java.util.Map;

public class ControllerID {

    public static final int GASCONTROLLER_ID = 0;
    public static final int LIGHTING_ID = 1;
    public static final int WATERCONRTOLLER_ID = 2;
    public static final int CLIMATECONTROLLER_ID = 3;
    public static final int ACCESSCONTROLLER_ID = 4;

    private String[] controllersID;
    private static Map<String, String> controllerStorage = new HashMap<>();

    public void getControllersID(){

    }

    private void setControllerStorage(final String[] controllersID){

        for (String singleID : controllersID) {
            if (singleID.startsWith("0")) {
                controllerStorage.put(singleID, AreasStorage.KITCHEN_AREA_NAME);
            } else if (singleID.startsWith("1")) {
                controllerStorage.put(singleID, AreasStorage.BAD_ROOM_AREA_NAME);
            } else if (singleID.startsWith("2")) {
                controllerStorage.put(singleID, AreasStorage.LIVING_ROOM_AREA_NAME);
            } else if (singleID.startsWith("3")) {
                controllerStorage.put(singleID, AreasStorage.LOBBY_AREA_NAME);
            } else if (singleID.startsWith("4")) {
                controllerStorage.put(singleID, AreasStorage.BATHROOM_AREA_NAME);
            } else if (singleID.startsWith("5")) {
                controllerStorage.put(singleID, AreasStorage.TOILET_AREA_NAME);
            }
        }
    }
}
