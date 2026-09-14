package com.groboot.mdaemergency.models;

import w6.l0;

/* loaded from: classes.dex */
public class Address {
    public String description;
    public double lat;
    public double lon;

    public Address() {
    }

    public Address(double d10, double d11) {
        this.lat = d10;
        this.lon = d11;
    }

    public Address(String str, double d10, double d11) {
        this.description = str;
        this.lat = d10;
        this.lon = d11;
    }

    public boolean equals(Object obj) {
        Address address = (Address) obj;
        return this.description.equals(address.description) && this.lat == address.lat && this.lon == address.lon;
    }

    public boolean isFullFields() {
        return !l0.l0(this.description) && this.lat > 0.0d && this.lon > 0.0d;
    }
}
