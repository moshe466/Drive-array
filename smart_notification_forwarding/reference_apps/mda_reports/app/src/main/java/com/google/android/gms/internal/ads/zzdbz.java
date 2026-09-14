package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class zzdbz implements zzdxg<ThreadFactory> {
    private static final zzdbz zzgpw = new zzdbz();

    public static zzdbz zzaqc() {
        return zzgpw;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (ThreadFactory) zzdxm.zza(new zzdbr(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
