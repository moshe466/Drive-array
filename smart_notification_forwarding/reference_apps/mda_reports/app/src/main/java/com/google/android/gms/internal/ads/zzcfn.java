package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcfn implements zzdxg<zzdhe<String>> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdq> zzfbr;
    private final zzdxp<zzdhd> zzfva;

    private zzcfn(zzdxp<zzdq> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<zzdhd> zzdxpVar3) {
        this.zzfbr = zzdxpVar;
        this.zzejv = zzdxpVar2;
        this.zzfva = zzdxpVar3;
    }

    public static zzcfn zzm(zzdxp<zzdq> zzdxpVar, zzdxp<Context> zzdxpVar2, zzdxp<zzdhd> zzdxpVar3) {
        return new zzcfn(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        final zzdq zzdqVar = this.zzfbr.get();
        final Context context = this.zzejv.get();
        return (zzdhe) zzdxm.zza(this.zzfva.get().submit(new Callable(zzdqVar, context) { // from class: com.google.android.gms.internal.ads.zzcfj
            private final Context zzcey;
            private final zzdq zzfum;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfum = zzdqVar;
                this.zzcey = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdq zzdqVar2 = this.zzfum;
                return zzdqVar2.zzbw().zzb(this.zzcey);
            }
        }), "Cannot return null from a non-@Nullable @Provides method");
    }
}
