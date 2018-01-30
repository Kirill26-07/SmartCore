package smartCore.areas;

import smartCore.controllers.energyControllers.ClimateController;
import smartCore.controllers.energyControllers.Lighting;
import smartCore.controllers.securityControllers.AccessController;
import smartCore.controllers.securityControllers.GasController;
import smartCore.controllers.securityControllers.WaterController;

public class HomeArea {

    private String name;

    private Lighting lightingController;
    private GasController gasController;
    private WaterController waterController;
    private AccessController accessController;
    private ClimateController climateController;


    HomeArea(String name, Lighting lightingController){

        this(name, lightingController, null, null, null, null);

    }

    HomeArea(String name, Lighting lightingController, GasController gasController){

        this(name, lightingController, gasController, null, null, null);

    }

    HomeArea(String name,
             Lighting lightingController,
             GasController gasController,
             WaterController waterController){

        this(name, lightingController, gasController, waterController, null, null);

    }

    HomeArea(String name,
             Lighting lightingController,
             GasController gasController,
             WaterController waterController,
             AccessController accessController){

        this(name, lightingController, gasController, waterController, accessController, null);

    }

    HomeArea(String name,
             Lighting lightingController,
             GasController gasController,
             WaterController waterController,
             AccessController accessController,
             ClimateController climateController){

        this.name = name;
        this.lightingController = lightingController;
        this.gasController = gasController;
        this.waterController = waterController;
        this.accessController = accessController;
        this.climateController = climateController;
    }

    public String getName() {
        return name;
    }

    public Lighting getLightingController() {
        return lightingController;
    }

    public GasController getGasController() {
        return gasController;
    }

    public WaterController getWaterController() {
        return waterController;
    }

    public AccessController getAccessController() {
        return accessController;
    }

    public ClimateController getClimateController() {
        return climateController;
    }
}
