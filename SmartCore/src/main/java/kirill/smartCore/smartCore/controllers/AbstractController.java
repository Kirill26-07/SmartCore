/**
 * Абстрактный класс контроллеров, реализует общее состояние контроллера:
 * controllerState - текущее состояние контроллера
 * CONTROLLER_ID - уникальный адрес контроллера
 * А также переопределяет методы equals и hashCode
 */

package kirill.smartCore.smartCore.controllers;

import java.util.Objects;

public abstract class AbstractController implements IController {

    protected boolean controllerState;
    protected final int CONTROLLER_ID;

    protected AbstractController(int controller_id) {
        CONTROLLER_ID = controller_id;
    }

    @Override
    public void setControllerState(boolean controllerState) {
        this.controllerState = controllerState;
    }

    @Override
    public boolean getControllerState(){
        return controllerState;
    }

    @Override
    public int getCONTROLLER_ID() {
        return CONTROLLER_ID;
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
    public abstract void switchOn();

    @Override
    public abstract void switchOf();
}
