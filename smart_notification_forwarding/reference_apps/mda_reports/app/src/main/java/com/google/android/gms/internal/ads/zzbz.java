package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* loaded from: classes.dex */
public enum zzbz implements zzdry {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3);

    private static final zzdrx<zzbz> zzen = new zzdrx<zzbz>() { // from class: com.google.android.gms.internal.ads.zzcb
    };
    private final int value;

    zzbz(int i) {
        this.value = i;
    }

    public static zzdsa zzaf() {
        return zzca.a;
    }

    public static zzbz zzi(int i) {
        if (i == 0) {
            return UNKNOWN_ENCRYPTION_METHOD;
        }
        if (i == 1) {
            return BITSLICER;
        }
        if (i == 2) {
            return TINK_HYBRID;
        }
        if (i != 3) {
            return null;
        }
        return UNENCRYPTED;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzbz.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.ads.zzdry
    public final int zzae() {
        return this.value;
    }
}
