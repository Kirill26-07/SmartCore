package kirill.smartCore.smartCore.model;

import kirill.smartCore.smartCore.controllers.energyControllers.Lighting;
import kirill.smartCore.smartCore.controllers.securityControllers.AccessController;
import kirill.smartCore.smartCore.controllers.securityControllers.GasController;
import kirill.smartCore.smartCore.controllers.securityControllers.WaterController;
import kirill.smartCore.smartCore.controllers.energyControllers.ClimateController;

public class HomeArea implements IHomeArea {

    private String name;
    private final int ID;

    private Lighting lightingController;
    private GasController gasController;
    private WaterController waterController;
    private AccessController accessController;
    private ClimateController climateController;

    public HomeArea(final String areaName, int areaID){
        this.name = areaName;
        this.ID = areaID;
    }

    @Override
    public void setLightingController(final Lighting lightingController) {
        this.lightingController = lightingController;
    }

    @Override
    public void setGasController(final GasController gasController) {
        this.gasController = gasController;
    }

    @Override
    public void setWaterController(final WaterController waterController) {
        this.waterController = waterController;
    }

    @Override
    public void setAccessController(final AccessController accessController) {
        this.accessController = accessController;
    }

    @Override
    public void setClimateController(final ClimateController climateController) {
        this.climateController = climateController;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Lighting getLightingController() {
        return lightingController;
    }

    @Override
    public GasController getGasController() {
        return gasController;
    }

    @Override
    public WaterController getWaterController() {
        return waterController;
    }

    @Override
    public AccessController getAccessController() {
        return accessController;
    }

    @Override
    public ClimateController getClimateController() {
        return climateController;
    }
}
