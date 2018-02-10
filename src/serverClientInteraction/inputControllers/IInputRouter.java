package serverClientInteraction.inputControllers;

public interface IInputRouter<T1, T2> {

    void input(final T1 deviceID, final T2 externalInput);

}
