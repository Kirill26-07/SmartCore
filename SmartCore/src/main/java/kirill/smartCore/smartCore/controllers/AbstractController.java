/**
 * Абстрактный класс контроллеров, реализует общее состояние контроллера:
 * controllerState - текущее состояние контроллера
 * CONTROLLER_ID - уникальный адрес контроллера
 * А также переопределяет методы equals и hashCode
 */

package kirill.smartCore.smartCore.controllers;

import kirill.smartCore.smartCore.model.HomeArea;

import java.util.Objects;

public abstract class AbstractController implements IController {

    private byte controllerState;
    protected final int CONTROLLER_ID;

    protected AbstractController(int controller_id) {
        CONTROLLER_ID = controller_id;
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
    public byte getControllerState(){
        return this.controllerState;
    }

    @Override
    public void setControllerState(byte controllerState){
        this.controllerState = controllerState;
    }

    @Override
    public abstract void switchOn();

    @Override
    public abstract void switchOf();

    @Override
    public abstract void inputData(byte inputValue, HomeArea.AreaPreSettings areaPreSettings);

    public enum controllerStates {
        ON(1),
        OFF(0),
        ALARM(2),
        NOT_AVALIABLE(3);

        int state;

        controllerStates(int state){
            this.state = state;
        }

        public int getState() {
            return state;
        }
    }
}
