package com.groboot.mdaemergency.models.location;

/* loaded from: classes.dex */
public class Geometry {
    Location location;
    String location_type;
    Viewport viewport;

    public Location getLocation() {
        return this.location;
    }

    public String getLocation_type() {
        return this.location_type;
    }

    public Viewport getViewport() {
        return this.viewport;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLocation_type(String str) {
        this.location_type = str;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }
}
