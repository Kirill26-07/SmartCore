package smartCore.areas;

import smartCore.energyControllers.Lighting;
import smartCore.securityControllers.GasController;
import smartCore.securityControllers.WaterController;

public class Kitchen extends EnergyController {

    private final Lighting kitchenLightingController;
    private final GasController kitchenGasLeakageController;
    private final WaterController kitchenWaterLeakageController;

    public Kitchen(Lighting kitchenLightingController) {

        this(kitchenLightingController, null, null);

    }

    private Kitchen(Lighting kitchenLightingController, GasController kitchenGasLeakageController){

        this(kitchenLightingController, kitchenGasLeakageController, null);
    }

    private Kitchen(Lighting lightingController, GasController gasLeakageController, WaterController waterLeakageController){

        this.kitchenLightingController = lightingController;
        this.kitchenGasLeakageController = gasLeakageController;
        this.kitchenWaterLeakageController = waterLeakageController;


    }

    public void switchLighting(){

    }

    public void switchGas(){

    }

    public void switchWater(){

    }

}

