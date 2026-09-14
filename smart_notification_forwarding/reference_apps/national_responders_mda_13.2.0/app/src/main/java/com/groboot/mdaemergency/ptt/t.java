package com.groboot.mdaemergency.ptt;

import il.org.mda.health.R;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum t {
    available(1, R.string.available),
    busy(2, R.string.contact_busy),
    unavailable(3, R.string.contact_disabled),
    offline(4, R.string.offline_contact);

    private static Map map = new HashMap();
    private int name;
    private int value;

    static {
        for (t tVar : values()) {
            map.put(Integer.valueOf(tVar.value), tVar);
        }
    }

    t(int i10, int i11) {
        this.value = i10;
        this.name = i11;
    }

    public static t valueOf(int i10) {
        return (t) map.get(Integer.valueOf(i10));
    }

    public int getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
