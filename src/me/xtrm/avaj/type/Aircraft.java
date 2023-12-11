package me.xtrm.avaj.type;

/**
 * @author kiroussa
 */
public class Aircraft {
    private static int CURRENT_ID = 0;

    private final int id;
    private final String name;
    private final AircraftType type;

    public Aircraft(String name, AircraftType type) {
        this.id = CURRENT_ID;
        CURRENT_ID++;

        this.name = name;
        this.type = type;
    }
}
