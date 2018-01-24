package serverClientInteraction.inputControllers;

public class InputRouter<T1, T2> implements IRouter<T1, T2> {

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
