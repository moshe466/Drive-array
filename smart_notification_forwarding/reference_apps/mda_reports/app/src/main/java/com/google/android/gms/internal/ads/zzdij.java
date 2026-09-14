package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzdij {
    private zzdnk zzgxy;

    private zzdij(zzdnk zzdnkVar) {
        this.zzgxy = zzdnkVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzdij a(zzdnk zzdnkVar) {
        if (zzdnkVar == null || zzdnkVar.zzavx() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new zzdij(zzdnkVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdnk a() {
        return this.zzgxy;
    }

    public final String toString() {
        return zzdiz.zzb(this.zzgxy).toString();
    }
}
