/**
 * Класс реализующий Output данных в консоль
 */
package kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController;

public class ConsolePrinter implements IPrinter {


    @Override
    public void output(final String smartHomeOutput) {

        System.out.println(smartHomeOutput);

    }

    @Override
    public void output(final StringBuilder smartHomeOutput) {

        System.out.println(smartHomeOutput);

    }
}
