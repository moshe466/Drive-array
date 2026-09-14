package com.groboot.mdaemergency.locations;

/* loaded from: classes.dex */
public enum a {
    unknown(0),
    geofence(1),
    transitionRecognition(2),
    SchedulingLocations(3),
    Fused(4);

    private final int value;

    a(int i10) {
        this.value = i10;
    }

    public static a get(int i10) {
        for (a aVar : values()) {
            if (aVar.value == i10) {
                return aVar;
            }
        }
        return null;
    }

    public int getValue() {
        return this.value;
    }
}
