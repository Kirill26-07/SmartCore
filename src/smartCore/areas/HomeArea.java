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

    public HomeArea(String name){
        this.name = name;
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

    public void setLightingController(Lighting lightingController) {
        this.lightingController = lightingController;
    }

    public void setGasController(GasController gasController) {
        this.gasController = gasController;
    }

    public void setWaterController(WaterController waterController) {
        this.waterController = waterController;
    }

    public void setAccessController(AccessController accessController) {
        this.accessController = accessController;
    }

    public void setClimateController(ClimateController climateController) {
        this.climateController = climateController;
    }
}
