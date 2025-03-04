package model;

public enum LocationType {
    HOSPITAL("Hospital"),
    CLINIC("Clinic");

    private final String displayName;

    LocationType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}