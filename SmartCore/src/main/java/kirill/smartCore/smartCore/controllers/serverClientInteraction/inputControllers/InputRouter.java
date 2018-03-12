/**
 * Класс реализующим Input and processing data from Serial port
 */

package kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers;

import kirill.smartCore.smartCore.controllers.AbstractIOController;

public class InputRouter extends AbstractIOController {

    private byte homeAreaID;
    private byte deviceID;
    private byte sensorSignal;

    public void inputSignal() throws InterruptedException {
        boolean connected = smartHome.openConnection();
        System.out.println("Connection success: " + connected);
        Thread.sleep(1000);

        while (connected){

            byte[] inputData = smartHome.bytesSerialRead(2);
            homeAreaID = inputData[0];
            deviceID = inputData[1];
            sensorSignal = inputData[2];
            inputDataRouting();
        }
    }

    private void inputDataRouting(){
        System.out.printf("\nhomeAreaID - %d;\ndeviceID - %d;\nsensorSignal - %d.\n", homeAreaID, deviceID, sensorSignal);
    }
}

