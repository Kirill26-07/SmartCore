package kirill.smartCore.smartCore.model;

import kirill.smartCore.smartCore.controllers.energyControllers.ClimateController;
import kirill.smartCore.smartCore.controllers.energyControllers.Lighting;
import kirill.smartCore.smartCore.controllers.securityControllers.AccessController;
import kirill.smartCore.smartCore.controllers.securityControllers.GasController;
import kirill.smartCore.smartCore.controllers.securityControllers.WaterController;

public interface IHomeArea {

    void inputData(byte controllerID, byte inputData);

    void setLightingController(Lighting lightingController);

    void setGasController(GasController gasController);

    void setWaterController(WaterController waterController);

    void setAccessController(AccessController accessController);

    void setClimateController(ClimateController climateController);

    String getName();

    Lighting getLightingController();

    GasController getGasController();

    WaterController getWaterController();

    AccessController getAccessController();

    ClimateController getClimateController();
}
