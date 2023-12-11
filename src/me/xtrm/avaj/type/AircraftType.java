package me.xtrm.avaj.type;

/**
 * @author kiroussa
 */
public enum AircraftType {
    JETPLANE("JetPlane"),
    HELICOPTER("Helicopter"),
    BALOON("Baloon"),
    ;

    private final String titleName;

    AircraftType(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleName() {
        return titleName;
    }
}
