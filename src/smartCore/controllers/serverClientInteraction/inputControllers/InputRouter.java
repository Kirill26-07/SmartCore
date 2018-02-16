package smartCore.controllers.serverClientInteraction.inputControllers;


import smartCore.controllers.MainController;

public class InputRouter<T1, T2> extends MainController implements IInputRouter<T1, T2> {

    private T1 deviceID;
    private T2 sensorSignal;

    @Override
    public void input(final T1 deviceID, final T2 externalSensorSignal) {

        this.sensorSignal = externalSensorSignal;
        this.deviceID = deviceID;
    }

    public T1 getDeviceID() {
        return deviceID;
    }

    public T2 getSensorSignal() {
        return sensorSignal;
    }
}
