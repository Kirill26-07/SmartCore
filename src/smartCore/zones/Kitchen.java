package smartCore.zones;

import smartCore.energyControllers.Lighting;
import smartCore.securityControllers.GasController;
import smartCore.securityControllers.WaterController;

public class Kitchen {

    private final Lighting lightingControl;
    private final GasController gasLeakageController;
    private final WaterController waterLeakageController;

    public Kitchen(Lighting lightingControl, GasController gasLeakageController, WaterController waterLeakageController) {
        this.lightingControl = lightingControl;
        this.gasLeakageController = gasLeakageController;
        this.waterLeakageController = waterLeakageController;
    }

}
