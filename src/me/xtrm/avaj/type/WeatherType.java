package me.xtrm.avaj.type;

/**
 * Enum of different valid types/state of weather.
 *
 * @author kiroussa
 */
public enum WeatherType {
    RAIN("Rain"),
    FOG("Fog"),
    SUN("Sun"),
    SNOW("Snow")
    ;

    private final String titleName;

    WeatherType(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleName() {
        return titleName;
    }
}
