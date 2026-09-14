package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzhc {
    public static final zzhc zzagb = new zzhc(1.0f, 1.0f);
    public final float zzagc;
    public final float zzagd;
    private final int zzage;

    public zzhc(float f, float f2) {
        this.zzagc = f;
        this.zzagd = f2;
        this.zzage = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhc.class == obj.getClass()) {
            zzhc zzhcVar = (zzhc) obj;
            if (this.zzagc == zzhcVar.zzagc && this.zzagd == zzhcVar.zzagd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzagc) + 527) * 31) + Float.floatToRawIntBits(this.zzagd);
    }

    public final long zzdu(long j) {
        return j * this.zzage;
    }
}
