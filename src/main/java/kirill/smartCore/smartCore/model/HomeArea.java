/**
 * Класс реализует ту или иную контролируемую зону, в которую входят контроллеры управляющие
 * заданными системами. Данное разграничени по зонам, делает систему более гибкой и удобной в управлении,
 * таккак при боьшом колличестве одинаковых датчиков они разграничены по управляемым зонам.
 */

package kirill.smartCore.smartCore.model;

import kirill.smartCore.smartCore.controllers.AbstractController;
import kirill.smartCore.smartCore.controllers.interactoinWithUser.settings.AreaSettings;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HomeArea<V extends AbstractController> implements IHomeArea<V> {

    private final String name;

    private Map<Integer, V> areaControllers = new HashMap<>();
    private AreaSettings areaPreSettings;

    public HomeArea(final String areaName) {
        this.name = areaName;
    }

    public void newAreaSettings() {

    }

    @Override
    public boolean inputData(final int controllerID, final int inputData) {
        AbstractController controller = areaControllers.get(controllerID);
        return controller.inputData(inputData, areaPreSettings);
    }

    @Override
    public void setAreaControllers(final int controllerID, final V controller) {
        areaControllers.put(controllerID, controller);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HomeArea)) return false;
        HomeArea homeArea = (HomeArea) o;
        return Objects.equals(name, homeArea.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
