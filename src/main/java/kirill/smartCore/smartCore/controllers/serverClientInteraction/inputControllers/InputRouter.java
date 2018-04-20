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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class InputRouter extends AbstractIOController implements IInputRouter {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static final Logger logging = LogManager.getLogger(InputRouter.class.getName());
    private static final int INPUT_BYTE_LIMIT = 2;

    private static boolean connected;

    public void inputSignal() throws ConnectionFailedException {

        try {
            openInputConnection();
        } catch (InterruptedException e) {
            logging.fatal(e.getStackTrace());
        }

        executorService.submit(new InputStream());

        if (!connected) {
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
        } catch (WrongInputDataException e) {
            logging.error("Wrong input value!");
        }

        HomeArea homeArea = (HomeArea) AreasStorage.getHomeArea(areaID);

        if (homeArea.getName().equals(AreasStorage.NOT_FOUND)) {
            logging.error("Area is not found!");
        } else {
            homeArea.inputData(controllerID, sensorSignal);
        }
    }

    private void openInputConnection() throws InterruptedException {
        connected = smartHome.openConnection();
        System.out.println("Connection success: " + connected);
        Thread.sleep(1000);
    }

    public static void closeConnection(){
        smartHome.closeConnection();
        connected = false;
    }


    private class InputStream implements Runnable {

        private byte homeAreaID;
        private byte controllerID;
        private byte sensorSignal;

        @Override
        public void run() {

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

