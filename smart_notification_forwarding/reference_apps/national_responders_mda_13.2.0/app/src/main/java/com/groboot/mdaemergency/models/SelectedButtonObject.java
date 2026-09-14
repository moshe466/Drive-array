package com.groboot.mdaemergency.models;

/* loaded from: classes.dex */
public class SelectedButtonObject {
    public int id;

    public SelectedButtonObject(int i10) {
        this.id = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.id == ((SelectedButtonObject) obj).id;
    }

    public int hashCode() {
        return 31 + this.id;
    }
}
