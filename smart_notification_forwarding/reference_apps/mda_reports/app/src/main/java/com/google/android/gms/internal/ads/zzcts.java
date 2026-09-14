package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcts implements zzcub<zzctt> {
    private final zzazb zzbll;
    private final zzdhd zzfov;
    private final Context zzup;

    public zzcts(zzdhd zzdhdVar, Context context, zzazb zzazbVar) {
        this.zzfov = zzdhdVar;
        this.zzup = context;
        this.zzbll = zzazbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzctt a() {
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzup).isCallerInstantApp();
        com.google.android.gms.ads.internal.zzq.zzkq();
        boolean zzay = zzawb.zzay(this.zzup);
        String str = this.zzbll.zzbma;
        com.google.android.gms.ads.internal.zzq.zzks();
        boolean zzwq = zzawh.zzwq();
        com.google.android.gms.ads.internal.zzq.zzkq();
        return new zzctt(isCallerInstantApp, zzay, str, zzwq, zzawb.zzav(this.zzup), DynamiteModule.getRemoteVersion(this.zzup, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.zzup, ModuleDescriptor.MODULE_ID));
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzctt> zzanc() {
        return this.zzfov.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzctv
            private final zzcts zzggw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggw = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzggw.a();
            }
        });
    }
}
