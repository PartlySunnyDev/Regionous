package me.partlysunny.regionous.api;

public abstract class AbstractXYZ implements XYZRegion {

    protected final String identifier;

    protected AbstractXYZ(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String identifier() {
        return identifier;
    }

}
