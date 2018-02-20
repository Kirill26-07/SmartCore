package kirill.smartCore.smartCore.areas;

import kirill.smartCore.smartCore.controllers.energyControllers.Lighting;
import kirill.smartCore.smartCore.controllers.securityControllers.AccessController;
import kirill.smartCore.smartCore.controllers.securityControllers.GasController;
import kirill.smartCore.smartCore.controllers.securityControllers.WaterController;
import kirill.smartCore.smartCore.controllers.energyControllers.ClimateController;

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
