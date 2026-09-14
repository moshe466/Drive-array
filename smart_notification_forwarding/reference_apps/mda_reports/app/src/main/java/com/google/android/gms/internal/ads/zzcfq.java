package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzcfq implements zzdxg<zzdhe<String>> {
    private final zzdxp<Context> zzejv;
    private final zzdxp<zzdcr> zzfet;

    private zzcfq(zzdxp<zzdcr> zzdxpVar, zzdxp<Context> zzdxpVar2) {
        this.zzfet = zzdxpVar;
        this.zzejv = zzdxpVar2;
    }

    public static zzcfq zzad(zzdxp<zzdcr> zzdxpVar, zzdxp<Context> zzdxpVar2) {
        return new zzcfq(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        zzdcr zzdcrVar = this.zzfet.get();
        final Context context = this.zzejv.get();
        return (zzdhe) zzdxm.zza(zzdcrVar.zzu(zzdco.WEBVIEW_COOKIE).zzc(new Callable(context) { // from class: com.google.android.gms.internal.ads.zzcfh
            private final Context zzcri;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcri = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager zzbd = com.google.android.gms.ads.internal.zzq.zzks().zzbd(this.zzcri);
                return zzbd != null ? zzbd.getCookie("googleads.g.doubleclick.net") : "";
            }
        }).zza(1L, TimeUnit.SECONDS).zza(Exception.class, zzcfk.a).zzaqg(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
