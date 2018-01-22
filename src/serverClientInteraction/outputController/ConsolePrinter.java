package serverClientInteraction.outputController;

public class ConsolePrinter implements IPrinter {


    @Override
    public void output(String smartHomeOutput) {

        System.out.println(smartHomeOutput);

    }

    @Override
    public void output(StringBuilder smartHomeOutput) {

        System.out.println(smartHomeOutput);

    }
}
