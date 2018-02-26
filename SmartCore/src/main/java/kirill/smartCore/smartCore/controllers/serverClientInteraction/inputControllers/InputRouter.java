package kirill.smartCore.smartCore.controllers.serverClientInteraction.inputControllers;

import kirill.smartCore.smartCore.controllers.AbstractIOController;

public class InputRouter<T1, T2>  extends AbstractIOController {

    private T1 deviceID;
    private T2 sensorSignal;

    public void inputSignal() throws InterruptedException {
        boolean connected = smartHome.openConnection();
        System.out.println("Connection success: " + connected);
        Thread.sleep(1000);

        while (connected){
            sensorSignal = (T2) smartHome.serialRead(-1);
            System.out.println(sensorSignal);
        }
    }

    public T1 getDeviceID() {
        return deviceID;
    }

    public T2 getSensorSignal() {
        return sensorSignal;
    }

}
