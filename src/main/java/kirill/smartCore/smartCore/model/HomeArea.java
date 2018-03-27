/**
 * Класс реализует ту или иную контролируемую зону, в которую входят контроллеры управляющие
 * заданными системами. Данное разграничени по зонам, делает систему более гибкой и удобной в управлении,
 * таккак при боьшом колличестве одинаковых датчиков они разграничены по управляемым зонам.
 */

package kirill.smartCore.smartCore.model;

import kirill.smartCore.smartCore.controllers.energyControllers.Lighting;
import kirill.smartCore.smartCore.controllers.securityControllers.AccessController;
import kirill.smartCore.smartCore.controllers.securityControllers.GasController;
import kirill.smartCore.smartCore.controllers.securityControllers.WaterController;
import kirill.smartCore.smartCore.controllers.energyControllers.ClimateController;

import java.util.Objects;

public class HomeArea implements IHomeArea {

    private String name;

    private Lighting lightingController;
    private GasController gasController;
    private WaterController waterController;
    private AccessController accessController;
    private ClimateController climateController;

    private AreaPreSettings areaPreSettings = new AreaPreSettings();

    public HomeArea(final String areaName){
        this.name = areaName;
    }

    @Override
    public void inputData(byte controllerID, byte inputData) {

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

    public class AreaPreSettings {

        private double MAX_TEMP = 28.0;
        private double MIN_TEMP = 18.0;

        private byte MAX_HUMIDITY = 80;
        private byte MIN_HUMIDITY = 30;

        private short MAX_CO2 = 900;

        private boolean AUTOMATIC_ELECTRIC_SWITCH;
        private boolean AUTOMATIC_LIGHTNING_SWITCH;
        private short LIGHTING_DELAY_TIME = 3000;

        public void setMAX_TEMP(double MAX_TEMP) {
            this.MAX_TEMP = MAX_TEMP;
        }

        public void setMIN_TEMP(double MIN_TEMP) {
            this.MIN_TEMP = MIN_TEMP;
        }

        public void setMAX_HUMIDITY(byte MAX_HUMIDITY) {
            this.MAX_HUMIDITY = MAX_HUMIDITY;
        }

        public void setMIN_HUMIDITY(byte MIN_HUMIDITY) {
            this.MIN_HUMIDITY = MIN_HUMIDITY;
        }

        public void setMAX_CO2(byte MAX_CO2) {
            this.MAX_CO2 = MAX_CO2;
        }

        public void setAUTOMATIC_ELECTRIC_SWITCH(boolean AUTOMATIC_ELECTRIC_SWITCH) {
            this.AUTOMATIC_ELECTRIC_SWITCH = AUTOMATIC_ELECTRIC_SWITCH;
        }

        public void setAUTOMATIC_LIGHTNING_SWITCH(boolean AUTOMATIC_LIGHTNING_SWITCH) {
            this.AUTOMATIC_LIGHTNING_SWITCH = AUTOMATIC_LIGHTNING_SWITCH;
        }

        public void setLIGHTING_DELAY_TIME(short LIGHTING_DELAY_TIME) {
            this.LIGHTING_DELAY_TIME = LIGHTING_DELAY_TIME;
        }

        public double getMAX_TEMP() {
            return MAX_TEMP;
        }

        public double getMIN_TEMP() {
            return MIN_TEMP;
        }

        public byte getMAX_HUMIDITY() {
            return MAX_HUMIDITY;
        }

        public byte getMIN_HUMIDITY() {
            return MIN_HUMIDITY;
        }

        public short getMAX_CO2() {
            return MAX_CO2;
        }

        public boolean isAUTOMATIC_ELECTRIC_SWITCH() {
            return AUTOMATIC_ELECTRIC_SWITCH;
        }

        public boolean isAUTOMATIC_LIGHTNING_SWITCH() {
            return AUTOMATIC_LIGHTNING_SWITCH;
        }

        public short getLIGHTING_DELAY_TIME() {
            return LIGHTING_DELAY_TIME;
        }
    }

}
