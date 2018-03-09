package kirill.smartCore.smartCore.model.storage;

import java.util.HashMap;
import java.util.Map;

public class ControllerID {

    private String[] controllersID;
    private static Map<String, String> controllerStorage = new HashMap<>();

    public void getControllersID(){

    }

    private void setControllerStorage(final String[] controllersID){

        for(int i = 0; i < controllersID.length; i++){
            if(controllersID[i].startsWith("0")){
                controllerStorage.put(controllersID[i], AreasStorage.KITCHEN_AREA_NAME);
            }
            else if(controllersID[i].startsWith("1")){
                controllerStorage.put(controllersID[i], AreasStorage.BAD_ROOM_AREA_NAME);
            }
            else if(controllersID[i].startsWith("2")){
                controllerStorage.put(controllersID[i], AreasStorage.LIVING_ROOM_AREA_NAME);
            }
            else if(controllersID[i].startsWith("3")){
                controllerStorage.put(controllersID[i], AreasStorage.LOBBY_AREA_NAME);
            }
            else if(controllersID[i].startsWith("4")){
                controllerStorage.put(controllersID[i], AreasStorage.BATHROOM_AREA_NAME);
            }
            else if(controllersID[i].startsWith("5")){
                controllerStorage.put(controllersID[i], AreasStorage.TOILET_AREA_NAME);
            }
        }

    }

}
