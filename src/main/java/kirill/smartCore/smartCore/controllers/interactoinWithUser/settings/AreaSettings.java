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


    public double getMaxTemp() {
        return MAX_TEMP;
    }

    public double getMinTemp() {
        return MIN_TEMP;
    }

    public int getMaxHumidity() {
        return MAX_HUMIDITY;
    }

    public int getMinHumidity() {
        return MIN_HUMIDITY;
    }

    public int getMaxCO2() {
        return MAX_CO2;
    }

    public boolean isAutomaticElectricSwitch() {
        return AUTOMATIC_ELECTRIC_SWITCH;
    }

    public boolean isAutomaticLightningSwitch() {
        return AUTOMATIC_LIGHTNING_SWITCH;
    }

    public int getLightningDelayTime() {
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


        public AreaSettingsBuilder setMaxTemp(final double userMax_temp) {
            this.max_temp = userMax_temp;
            return this;
        }

        public AreaSettingsBuilder setMinTemp(final double userMin_temp) {
            this.min_temp = userMin_temp;
            return this;
        }

        public AreaSettingsBuilder setMaxHumidity(final int userMax_humidity) {
            this.max_humidity = userMax_humidity;
            return this;
        }

        public AreaSettingsBuilder setMinHumidity(final int userMin_humidity) {
            this.min_humidity = userMin_humidity;
            return this;
        }

        public AreaSettingsBuilder setMaxCO2(final int userMax_co2) {
            this.max_co2 = userMax_co2;
            return this;
        }

        public AreaSettingsBuilder setAutomaticElectricSwitch(final boolean userAutomatic_electric_switch) {
            this.automatic_electric_switch = userAutomatic_electric_switch;
            return this;
        }

        public AreaSettingsBuilder setAutomaticLightningSwitch(final boolean userAutomatic_lightning_switch) {
            this.automatic_lightning_switch = userAutomatic_lightning_switch;
            return this;
        }

        public AreaSettingsBuilder setLightningDelayTime(final int userLighting_delay_time) {
            this.lighting_delay_time = userLighting_delay_time;
            return this;
        }

        public AreaSettings build() {
            return new AreaSettings(this);
        }
    }
}

