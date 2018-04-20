package kirill.smartCore.smartCore.model;

public interface IHomeArea<V> {
    boolean inputData(int controllerID, int inputData);
    void setAreaControllers(int controllerID, V controller);
    String getName();
}
