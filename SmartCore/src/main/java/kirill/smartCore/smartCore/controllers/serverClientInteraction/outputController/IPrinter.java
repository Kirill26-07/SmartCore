package kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController;

public interface IPrinter {

    void output(final String smartHomeOutput);
    void output(final StringBuilder smartHomeOutput);

}
