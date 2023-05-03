package me.partlysunny.regionous.api;

public abstract class AbstractXZ implements XZRegion {

    protected final String identifier;
    protected boolean toSave = false;

    protected AbstractXZ(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String identifier() {
        return identifier;
    }

    @Override
    public boolean toSave() {
        return toSave;
    }

    @Override
    public void setToSave(boolean toSave) {
        this.toSave = toSave;
    }
}
