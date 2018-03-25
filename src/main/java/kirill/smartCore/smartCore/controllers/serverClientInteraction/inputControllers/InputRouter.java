/**
 * Класс реализующим Input and processing data from Serial port
 */

package kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers;

import kirill.smartCore.smartCore.controllers.AbstractIOController;
import kirill.smartCore.smartCore.exceptions.ConnectionFailedException;
import kirill.smartCore.smartCore.exceptions.WrongInputDataException;
import kirill.smartCore.smartCore.model.HomeArea;
import kirill.smartCore.smartCore.model.storage.AreasStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputRouter extends AbstractIOController {

    private static final Logger logging = LogManager.getLogger(InputRouter.class.getName());

    private boolean connected;
    private byte homeAreaID;
    private byte controllerID;
    private byte sensorSignal;

    public void inputSignal() throws ConnectionFailedException {
        try {
            openInputConnection();
        } catch (InterruptedException e) {
            logging.fatal(e.getStackTrace());
        }

        while (connected){
            byte[] inputData = smartHome.bytesSerialRead(2);
            homeAreaID = inputData[0];
            controllerID = inputData[1];
            sensorSignal = inputData[2];
            inputDataRouting();
        }

        if(!connected){
            throw new ConnectionFailedException();
        }
    }

    public void restartInputConnection() {
        smartHome.closeConnection();
        try {
            openInputConnection();
        } catch (InterruptedException e) {
            logging.fatal(e.getStackTrace());
        }
    }

    private void inputDataRouting() {
        String area = "";

        try {
            area = areaForAreaID(homeAreaID);
        }
        catch (WrongInputDataException e){
            logging.error("Wrong input value!");
        }

        HomeArea homeArea = (HomeArea)AreasStorage.getHomeArea(area);

        if(homeArea.getName().equals(AreasStorage.NOT_FOUND)){
          logging.error("Area is not found!");
        }
        else {
            homeArea.inputData(controllerID, sensorSignal);
        }
    }

    private String areaForAreaID(byte id) throws WrongInputDataException {
        switch (id) {
            case 0: {
                return AreasStorage.AreaName.KITCHEN.getName();
            }
            case 1: {
                return AreasStorage.AreaName.BAD_ROOM.getName();
            }
            case 2: {
                return AreasStorage.AreaName.LIVING_ROOM.getName();
            }
            case 3: {
                return AreasStorage.AreaName.LOBBY.getName();
            }
            case 4: {
                return AreasStorage.AreaName.BATHROOM.getName();
            }
            case 5: {
                return AreasStorage.AreaName.TOILET.getName();
            }
            default: {
                System.out.println("Wrong input value!");
                throw new WrongInputDataException();
            }
        }
    }

    private void openInputConnection() throws InterruptedException {
        this.connected = smartHome.openConnection();
        System.out.println("Connection success: " + connected);
        Thread.sleep(1000);
    }
}

