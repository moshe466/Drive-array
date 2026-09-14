package com.google.android.gms.internal.auth;

/* loaded from: classes.dex */
abstract class zzhk {
    public abstract int zza(int i, byte[] bArr, int i3, int i4);

    public final boolean zzb(byte[] bArr, int i, int i3) {
        if (zza(0, bArr, i, i3) != 0) {
            return false;
        }
        return true;
    }
}
