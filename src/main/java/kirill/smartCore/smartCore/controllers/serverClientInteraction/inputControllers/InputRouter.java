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

public class InputRouter extends AbstractIOController implements IInputRouter {

    private static final Logger logging = LogManager.getLogger(InputRouter.class.getName());
    private static final int INPUT_BYTE_LIMIT = 2;

    private boolean connected;

    public void inputSignal() throws ConnectionFailedException {

        Thread inputThread_1 = new InputThread();
        Thread inputThread_2 = new InputThread();

        inputThread_1.start();
        inputThread_2.start();

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

    private void inputDataRouting(byte homeAreaID, byte controllerID, byte sensorSignal) {
        String areaID = "";

        try {
            areaID = AreasStorage.getAreaName(homeAreaID);
        }
        catch (WrongInputDataException e){
            logging.error("Wrong input value!");
        }

        HomeArea homeArea = (HomeArea)AreasStorage.getHomeArea(areaID);

        if(homeArea.getName().equals(AreasStorage.NOT_FOUND)){
          logging.error("Area is not found!");
        }
        else {
            homeArea.inputData(controllerID, sensorSignal);
        }
    }


    private void openInputConnection() throws InterruptedException {
        this.connected = smartHome.openConnection();
        System.out.println("Connection success: " + connected);
        Thread.sleep(1000);
    }

    private class InputThread extends Thread {

        @Override
        public void run(){
            byte homeAreaID;
            byte controllerID;
            byte sensorSignal;

            try {
                openInputConnection();
            } catch (InterruptedException e) {
                logging.fatal(e.getStackTrace());
            }

            byte[] inputData;
            while (connected){
                inputData = smartHome.bytesSerialRead(INPUT_BYTE_LIMIT);
                homeAreaID = inputData[0];
                controllerID = inputData[1];
                sensorSignal = inputData[2];
                inputDataRouting(homeAreaID, controllerID, sensorSignal);
            }
        }
    }
}

