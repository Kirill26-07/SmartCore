package smartCore.settings;

import smartCore.areas.EnergyController;
import smartCore.areas.Kitchen;

import java.util.HashMap;
import java.util.Map;

public class DevicesAndAreas {

    private final Kitchen kitchen;
    private Map<Integer, EnergyController> devicesAndAreas = new HashMap<>();

    public DevicesAndAreas(Kitchen kitchen) {
        this.kitchen = kitchen;
    }


    public void getDevicesForAreas(int devicesID){

        devicesAndAreas.put(devicesID, kitchen);

    }

}
