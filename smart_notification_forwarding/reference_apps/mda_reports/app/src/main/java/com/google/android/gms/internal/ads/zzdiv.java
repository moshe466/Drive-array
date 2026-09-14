package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdit;
import java.security.GeneralSecurityException;
import java.util.Set;

/* loaded from: classes.dex */
final class zzdiv implements zzdit.zza {
    private final /* synthetic */ zzdii zzgyn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdiv(zzdii zzdiiVar) {
        this.zzgyn = zzdiiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final Set<Class<?>> zzase() {
        return this.zzgyn.zzase();
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final zzdid<?> zzasn() {
        zzdii zzdiiVar = this.zzgyn;
        return new zzdig(zzdiiVar, zzdiiVar.a());
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final Class<?> zzaso() {
        return this.zzgyn.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final Class<?> zzasp() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final <Q> zzdid<Q> zzb(Class<Q> cls) {
        try {
            return new zzdig(this.zzgyn, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }
}
