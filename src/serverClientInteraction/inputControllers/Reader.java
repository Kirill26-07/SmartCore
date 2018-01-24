package serverClientInteraction.inputControllers;

public class Reader<T1, T2> implements IReader<T1, T2>{

    private T2 sensorSignal;

    @Override
    public void input(T1 deviceID, T2 externalSensorSignal) {

        this.sensorSignal = externalSensorSignal;
    }


}
