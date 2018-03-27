/**
 * Enum команд используемых для OutputRouter
 */
package kirill.smartCore.smartCore.model.storage;

public enum ExternalCommands {

    GET_AVAILABLE_CONTROLLERS,
    ON(1),
    OFF(0);

    int command;

    ExternalCommands(){

    }

    ExternalCommands(int command){
        this.command = command;
    }

    public int getCommand() {
        return command;
    }
}
