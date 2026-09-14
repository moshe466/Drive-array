package com.groboot.mdaemergency.enums;

/* loaded from: classes.dex */
public enum g {
    Admin(0),
    Conan(1),
    Team(2),
    Emergency(3),
    CancelConan(4);

    private int key;

    g(int i10) {
        this.key = i10;
    }

    public static g getById(int i10) {
        for (g gVar : values()) {
            if (gVar.key == i10) {
                return gVar;
            }
        }
        return null;
    }

    public int getKey() {
        return this.key;
    }
}
