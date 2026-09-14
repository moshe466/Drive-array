package com.google.android.gms.internal.ads;

import io.fabric.sdk.android.services.network.HttpRequest;

/* loaded from: classes.dex */
final class zzail implements Runnable {
    private final /* synthetic */ String zzczd;
    private final /* synthetic */ zzaih zzcze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzail(zzaih zzaihVar, String str) {
        this.zzcze = zzaihVar;
        this.zzczd = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdi zzbdiVar;
        zzbdiVar = this.zzcze.zzcza;
        zzbdiVar.loadData(this.zzczd, "text/html", HttpRequest.CHARSET_UTF8);
    }
}
