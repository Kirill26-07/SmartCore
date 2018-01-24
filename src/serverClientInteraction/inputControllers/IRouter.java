package serverClientInteraction.inputControllers;

public interface IRouter<T1, T2> {

    void input(T1 deviceID, T2 externalInput);

}
