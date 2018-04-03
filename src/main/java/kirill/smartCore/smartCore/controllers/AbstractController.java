/**
 * Абстрактный класс контроллеров, реализует общее состояние контроллера:
 * controllerState - текущее состояние контроллера
 * CONTROLLER_ID - уникальный адрес контроллера
 * А также переопределяет методы equals и hashCode
 */

package kirill.smartCore.smartCore.controllers;

import kirill.smartCore.smartCore.controllers.interactoinWithUser.settings.AreaSettings;
import kirill.smartCore.smartCore.controllers.serverClientInteraction.outputController.ComPortOutputRouter;
import kirill.smartCore.smartCore.model.storage.ExternalCommands;

import java.util.Objects;

public abstract class AbstractController implements IController {

    private static ComPortOutputRouter comPortOutputRouter = new ComPortOutputRouter();

    protected int controllerState;
    private final int CONTROLLER_ID;
    private final String AREA_ID;

    protected AbstractController(final int controller_id, final String area_id) {
        this.CONTROLLER_ID = controller_id;
        this.AREA_ID = area_id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractController)) return false;
        AbstractController that = (AbstractController) o;
        return CONTROLLER_ID == that.CONTROLLER_ID;
    }

    @Override
    public int hashCode() {

        return Objects.hash(CONTROLLER_ID);
    }

    @Override
    public void switchOn() {
        comPortOutputRouter.output(AREA_ID, CONTROLLER_ID, ExternalCommands.ON);
    }

    @Override
    public void switchOf() {
        comPortOutputRouter.output(AREA_ID, CONTROLLER_ID, ExternalCommands.OFF);
    }

    @Override
    public abstract boolean inputData(final int inputValue, final AreaSettings areaPreSettings);

    public enum controllerStates {
        ON(1),
        OFF(0),
        ALARM(2),
        NOT_AVALIABLE(3);

        int state;

        controllerStates(final int state){
            this.state = state;
        }

        public int getState() {
            return state;
        }
    }
}
