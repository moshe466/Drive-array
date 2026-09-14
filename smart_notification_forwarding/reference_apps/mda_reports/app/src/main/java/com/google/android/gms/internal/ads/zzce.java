package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* loaded from: classes.dex */
public enum zzce implements zzdry {
    UNKNOWN_PROTO(0),
    AFMA_SIGNALS(1),
    UNITY_SIGNALS(2),
    PARTNER_SIGNALS(3);

    private static final zzdrx<zzce> zzen = new zzdrx<zzce>() { // from class: com.google.android.gms.internal.ads.zzch
    };
    private final int value;

    zzce(int i) {
        this.value = i;
    }

    public static zzdsa zzaf() {
        return zzcg.a;
    }

    public static zzce zzk(int i) {
        if (i == 0) {
            return UNKNOWN_PROTO;
        }
        if (i == 1) {
            return AFMA_SIGNALS;
        }
        if (i == 2) {
            return UNITY_SIGNALS;
        }
        if (i != 3) {
            return null;
        }
        return PARTNER_SIGNALS;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzce.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.ads.zzdry
    public final int zzae() {
        return this.value;
    }
}
