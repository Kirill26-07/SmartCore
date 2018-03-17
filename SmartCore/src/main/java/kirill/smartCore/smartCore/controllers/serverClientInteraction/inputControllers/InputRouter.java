/**
 * Класс реализующим Input and processing data from Serial port
 */

package kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers;

import kirill.smartCore.smartCore.controllers.AbstractIOController;
import kirill.smartCore.smartCore.exceptions.WrongInputDataException;
import kirill.smartCore.smartCore.model.storage.AreasStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputRouter extends AbstractIOController {

    private static final Logger logging = LogManager.getLogger(InputRouter.class.getName());

    private byte homeAreaID;
    private byte controllerID;
    private byte sensorSignal;

    public void inputSignal() throws InterruptedException {
        boolean connected = smartHome.openConnection();
        System.out.println("Connection success: " + connected);
        Thread.sleep(1000);

        while (connected) {

            byte[] inputData = smartHome.bytesSerialRead(2);
            homeAreaID = inputData[0];
            controllerID = inputData[1];
            sensorSignal = inputData[2];
            inputDataRouting();
        }
    }

    private void inputDataRouting() {

        String area = "";
        try {
            area = areaForAreaID(homeAreaID);
        }catch (WrongInputDataException e){
            logging.error("Wrong input value!");
        }

        AreasStorage.getHomeArea(area).inputData(controllerID, sensorSignal);
    }

    private String areaForAreaID(byte id) throws WrongInputDataException {
        switch (homeAreaID) {
            case 0: {
                return AreasStorage.KITCHEN_AREA_NAME;
            }
            case 1: {
                return AreasStorage.BAD_ROOM_AREA_NAME;
            }
            case 2: {
                return AreasStorage.LIVING_ROOM_AREA_NAME;
            }
            case 3: {
                return AreasStorage.LOBBY_AREA_NAME;
            }
            case 4: {
                return AreasStorage.BATHROOM_AREA_NAME;
            }
            case 5: {
                return AreasStorage.TOILET_AREA_NAME;
            }
            default: {
                System.out.println("Wrong input value!");
                throw new WrongInputDataException();
            }
        }
    }
}

