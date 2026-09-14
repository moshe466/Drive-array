package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* loaded from: classes.dex */
public enum zzte implements zzdry {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);

    private static final zzdrx<zzte> zzen = new zzdrx<zzte>() { // from class: com.google.android.gms.internal.ads.zztd
    };
    private final int value;

    zzte(int i) {
        this.value = i;
    }

    public static zzdsa zzaf() {
        return zztf.a;
    }

    public static zzte zzbx(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzte.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.ads.zzdry
    public final int zzae() {
        return this.value;
    }
}
