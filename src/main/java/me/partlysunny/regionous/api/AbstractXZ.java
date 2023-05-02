package me.partlysunny.regionous.api;

public abstract class AbstractXZ implements XZRegion {

    protected final String identifier;

    protected AbstractXZ(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String identifier() {
        return identifier;
    }
}
