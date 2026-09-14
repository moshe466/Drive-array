package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* loaded from: classes.dex */
public final class zzcvy implements zzdxg<ApplicationInfo> {
    private final zzcvw zzgih;

    public zzcvy(zzcvw zzcvwVar) {
        this.zzgih = zzcvwVar;
    }

    public static ApplicationInfo zzb(zzcvw zzcvwVar) {
        return (ApplicationInfo) zzdxm.zza(zzcvwVar.zzany(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzb(this.zzgih);
    }
}
