package com.groboot.mdaemergency.models.location;

import java.util.List;

/* loaded from: classes.dex */
public class AddressComponent {
    String long_name;
    String short_name;
    List<String> types;

    public String getLong_name() {
        return this.long_name;
    }

    public String getShort_name() {
        return this.short_name;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setLong_name(String str) {
        this.long_name = str;
    }

    public void setShort_name(String str) {
        this.short_name = str;
    }

    public void setTypes(List<String> list) {
        this.types = list;
    }
}
