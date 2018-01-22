package serverClientInteraction.inputControllers;

public class Reader<T> implements IReader<T>{

    private T inputResult;

    @Override
    public void input(T externalInput) {

        this.inputResult = externalInput;
    }

    public T getInputResult() {

        return inputResult;
    }
}
