package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdit;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
final class zzdiw implements zzdit.zza {
    private final /* synthetic */ zzdid zzgyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdiw(zzdid zzdidVar) {
        this.zzgyo = zzdidVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final Set<Class<?>> zzase() {
        return Collections.singleton(this.zzgyo.zzarz());
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final zzdid<?> zzasn() {
        return this.zzgyo;
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final Class<?> zzaso() {
        return this.zzgyo.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final Class<?> zzasp() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdit.zza
    public final <Q> zzdid<Q> zzb(Class<Q> cls) {
        if (this.zzgyo.zzarz().equals(cls)) {
            return this.zzgyo;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }
}
