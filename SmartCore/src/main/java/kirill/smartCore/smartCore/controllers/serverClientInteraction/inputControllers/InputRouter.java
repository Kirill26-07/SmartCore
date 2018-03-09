/**
 * Класс реализующим Input and processing данных из Serial port
 */

package kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers;

import kirill.smartCore.smartCore.controllers.AbstractIOController;

public class InputRouter<T>  extends AbstractIOController {

    private T deviceID;
    private T sensorSignal;

    public void inputSignal() throws InterruptedException {
        boolean connected = smartHome.openConnection();
        System.out.println("Connection success: " + connected);
        Thread.sleep(1000);

        while (connected){

            String[] inputData = smartHome.arraySerialRead(1);
            deviceID = (T) inputData[1];
            sensorSignal = (T) inputData[2];
        }
    }

    public T getDeviceID() {
        return deviceID;
    }

    public T getSensorSignal() {
        return sensorSignal;
    }

}
