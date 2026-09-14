package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdit;
import java.security.GeneralSecurityException;
import java.util.Set;

/* loaded from: classes.dex */
final class zzdix implements zzdit.zza {
    private final /* synthetic */ zzdiu zzgyp;
    private final /* synthetic */ zzdii zzgyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdix(zzdiu zzdiuVar, zzdii zzdiiVar) {
        this.zzgyp = zzdiuVar;
        this.zzgyq = zzdiiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final Set<Class<?>> zzase() {
        return this.zzgyp.zzase();
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final zzdid<?> zzasn() {
        zzdiu zzdiuVar = this.zzgyp;
        return new zzdir(zzdiuVar, this.zzgyq, zzdiuVar.a());
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final Class<?> zzaso() {
        return this.zzgyp.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final Class<?> zzasp() {
        return this.zzgyq.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final <Q> zzdid<Q> zzb(Class<Q> cls) {
        try {
            return new zzdir(this.zzgyp, this.zzgyq, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }
}
