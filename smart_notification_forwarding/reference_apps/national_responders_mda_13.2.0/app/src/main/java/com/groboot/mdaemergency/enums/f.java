package com.groboot.mdaemergency.enums;

/* loaded from: classes.dex */
public enum f {
    registerPtt(2),
    request(3),
    whatApp(4);

    private int value;

    f(int i10) {
        this.value = i10;
    }

    public static f getById(int i10) {
        for (f fVar : values()) {
            if (fVar.value == i10) {
                return fVar;
            }
        }
        return null;
    }
}
