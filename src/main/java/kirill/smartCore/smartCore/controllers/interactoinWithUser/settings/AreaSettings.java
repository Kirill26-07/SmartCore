package kirill.smartCore.smartCore.controllers.interactoinWithUser.settings;

public class AreaSettings {

    private final double MAX_TEMP;
    private final double MIN_TEMP;

    private final int MAX_HUMIDITY;
    private final int MIN_HUMIDITY;

    private final int MAX_CO2;

    private final boolean AUTOMATIC_ELECTRIC_SWITCH;
    private final boolean AUTOMATIC_LIGHTNING_SWITCH;
    private final int LIGHTING_DELAY_TIME;

    private AreaSettings(AreaSettingsBuilder settingsBuilder) {
        this.MAX_TEMP = settingsBuilder.max_temp;
        this.MIN_TEMP = settingsBuilder.min_temp;
        this.MAX_HUMIDITY = settingsBuilder.max_humidity;
        this.MIN_HUMIDITY = settingsBuilder.min_humidity;
        this.MAX_CO2 = settingsBuilder.max_co2;
        this.AUTOMATIC_ELECTRIC_SWITCH = settingsBuilder.automatic_electric_switch;
        this.AUTOMATIC_LIGHTNING_SWITCH = settingsBuilder.automatic_lightning_switch;
        this.LIGHTING_DELAY_TIME = settingsBuilder.lighting_delay_time;
    }


    public double getMAX_TEMP() {
        return MAX_TEMP;
    }

    public double getMIN_TEMP() {
        return MIN_TEMP;
    }

    public int getMAX_HUMIDITY() {
        return MAX_HUMIDITY;
    }

    public int getMIN_HUMIDITY() {
        return MIN_HUMIDITY;
    }

    public int getMAX_CO2() {
        return MAX_CO2;
    }

    public boolean isAUTOMATIC_ELECTRIC_SWITCH() {
        return AUTOMATIC_ELECTRIC_SWITCH;
    }

    public boolean isAUTOMATIC_LIGHTNING_SWITCH() {
        return AUTOMATIC_LIGHTNING_SWITCH;
    }

    public int getLIGHTING_DELAY_TIME() {
        return LIGHTING_DELAY_TIME;
    }


    public class AreaSettingsBuilder {

        private double max_temp;
        private double min_temp;
        private int max_humidity;
        private int min_humidity;
        private int max_co2;
        private boolean automatic_electric_switch;
        private boolean automatic_lightning_switch;
        private int lighting_delay_time;


        public AreaSettingsBuilder setMAX_TEMP(double max_temp) {
            this.max_temp = max_temp;
            return this;
        }

        public AreaSettingsBuilder setMIN_TEMP(double min_temp) {
            this.min_temp = min_temp;
            return this;
        }

        public AreaSettingsBuilder setMAX_HUMIDITY(int max_humidity) {
            this.max_humidity = max_humidity;
            return this;
        }

        public AreaSettingsBuilder setMIN_HUMIDITY(int min_humidity) {
            this.min_humidity = min_humidity;
            return this;
        }

        public AreaSettingsBuilder setMAX_CO2(int max_co2) {
            this.max_co2 = max_co2;
            return this;
        }

        public AreaSettingsBuilder setAUTOMATIC_ELECTRIC_SWITCH(boolean automatic_electric_switch) {
            this.automatic_electric_switch = automatic_electric_switch;
            return this;
        }

        public AreaSettingsBuilder setAUTOMATIC_LIGHTNING_SWITCH(boolean automatic_lightning_switch) {
            this.automatic_lightning_switch = automatic_lightning_switch;
            return this;
        }

        public AreaSettingsBuilder setLIGHTING_DELAY_TIME(int lighting_delay_time) {
            this.lighting_delay_time = lighting_delay_time;
            return this;
        }

        public AreaSettings build() {
            return new AreaSettings(this);
        }
    }
}

