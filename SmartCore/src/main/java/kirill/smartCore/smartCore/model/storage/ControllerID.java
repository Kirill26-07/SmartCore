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

        for (String aControllersID : controllersID) {
            if (aControllersID.startsWith("0")) {
                controllerStorage.put(aControllersID, AreasStorage.KITCHEN_AREA_NAME);
            } else if (aControllersID.startsWith("1")) {
                controllerStorage.put(aControllersID, AreasStorage.BAD_ROOM_AREA_NAME);
            } else if (aControllersID.startsWith("2")) {
                controllerStorage.put(aControllersID, AreasStorage.LIVING_ROOM_AREA_NAME);
            } else if (aControllersID.startsWith("3")) {
                controllerStorage.put(aControllersID, AreasStorage.LOBBY_AREA_NAME);
            } else if (aControllersID.startsWith("4")) {
                controllerStorage.put(aControllersID, AreasStorage.BATHROOM_AREA_NAME);
            } else if (aControllersID.startsWith("5")) {
                controllerStorage.put(aControllersID, AreasStorage.TOILET_AREA_NAME);
            }
        }
    }
}
