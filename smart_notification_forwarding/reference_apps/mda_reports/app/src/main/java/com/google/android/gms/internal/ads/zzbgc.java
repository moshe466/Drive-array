package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zzbgc implements zzdxg<WeakReference<Context>> {
    private final zzbga zzejr;

    public zzbgc(zzbga zzbgaVar) {
        this.zzejr = zzbgaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (WeakReference) zzdxm.zza(this.zzejr.b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
