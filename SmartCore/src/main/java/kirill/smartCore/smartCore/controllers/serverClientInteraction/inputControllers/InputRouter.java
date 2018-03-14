/**
 * Класс реализующим Input and processing data from Serial port
 */

package kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers;

import kirill.smartCore.smartCore.controllers.AbstractIOController;
import kirill.smartCore.smartCore.model.storage.AreasStorage;

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
        switch (homeAreaID){
            case 0: {
                AreasStorage.getHomeArea(AreasStorage.KITCHEN_AREA_NAME).inputData(deviceID, sensorSignal);
                break;
            }
            case 1: {
                AreasStorage.getHomeArea(AreasStorage.BAD_ROOM_AREA_NAME).inputData(deviceID, sensorSignal);
                break;
            }
            case 2: {
                AreasStorage.getHomeArea(AreasStorage.LIVING_ROOM_AREA_NAME).inputData(deviceID, sensorSignal);
                break;
            }
            case 3: {
                AreasStorage.getHomeArea(AreasStorage.LOBBY_AREA_NAME).inputData(deviceID, sensorSignal);
                break;
            }
            case 4: {
                AreasStorage.getHomeArea(AreasStorage.BATHROOM_AREA_NAME).inputData(deviceID, sensorSignal);
                break;
            }
            case 5: {
                AreasStorage.getHomeArea(AreasStorage.TOILET_AREA_NAME).inputData(deviceID, sensorSignal);
                break;
            }
        }
    }
}

