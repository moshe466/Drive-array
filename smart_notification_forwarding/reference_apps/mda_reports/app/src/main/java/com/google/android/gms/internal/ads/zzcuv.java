package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcuv implements zzcub<zzcus> {
    private final Executor executor;

    @Nullable
    private final PackageInfo zzdip;
    private final zzava zzghl;
    private final String zzgho;

    public zzcuv(zzava zzavaVar, Executor executor, String str, @Nullable PackageInfo packageInfo) {
        this.zzghl = zzavaVar;
        this.executor = executor;
        this.zzgho = str;
        this.zzdip = packageInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhe a(Throwable th) {
        return zzdgs.zzaj(new zzcus(this.zzgho));
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcus> zzanc() {
        return zzdgs.zzb(zzdgs.zzb(this.zzghl.zza(this.zzgho, this.zzdip), zzcuu.a, this.executor), Throwable.class, new zzdgf(this) { // from class: com.google.android.gms.internal.ads.zzcux
            private final zzcuv zzghq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzghq = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdgf
            public final zzdhe zzf(Object obj) {
                return this.zzghq.a((Throwable) obj);
            }
        }, this.executor);
    }
}
