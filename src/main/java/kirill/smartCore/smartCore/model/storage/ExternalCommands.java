/**
 * Enum команд используемых для OutputRouter
 */
package kirill.smartCore.smartCore.model.storage;

public enum ExternalCommands {

    GET_AVAILABLE_CONTROLLERS,
    ON(1),
    OFF(0);

    private int command;

    ExternalCommands() {

    }

    ExternalCommands(final int commandForController) {
        this.command = commandForController;
    }

    public int getCommand() {
        return this.command;
    }
}
