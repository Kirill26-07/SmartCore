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

    public HomeArea(final String name){
        this.name = name;
    }

    public void setLightingController(final Lighting lightingController) {
        this.lightingController = lightingController;
    }

    public void setGasController(final GasController gasController) {
        this.gasController = gasController;
    }

    public void setWaterController(final WaterController waterController) {
        this.waterController = waterController;
    }

    public void setAccessController(final AccessController accessController) {
        this.accessController = accessController;
    }

    public void setClimateController(final ClimateController climateController) {
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
