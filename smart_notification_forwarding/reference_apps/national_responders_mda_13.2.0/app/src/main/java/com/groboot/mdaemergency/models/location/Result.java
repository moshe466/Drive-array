package com.groboot.mdaemergency.models.location;

import java.util.List;

/* loaded from: classes.dex */
public class Result {
    List<AddressComponent> address_components;
    String formatted_address;
    Geometry geometry;
    List<String> postcode_localities;
    List<String> types;

    public List<AddressComponent> getAddress_components() {
        return this.address_components;
    }

    public String getFormatted_address() {
        return this.formatted_address;
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    public List<String> getPostcode_localities() {
        return this.postcode_localities;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setAddress_components(List<AddressComponent> list) {
        this.address_components = list;
    }

    public void setFormatted_address(String str) {
        this.formatted_address = str;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public void setPostcode_localities(List<String> list) {
        this.postcode_localities = list;
    }

    public void setTypes(List<String> list) {
        this.types = list;
    }
}
