package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbcq implements Runnable {
    private final /* synthetic */ String zzdug;
    private final /* synthetic */ String zzedb;
    private final /* synthetic */ zzbcn zzedf;
    private final /* synthetic */ long zzedi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcq(zzbcn zzbcnVar, String str, String str2, long j) {
        this.zzedf = zzbcnVar;
        this.zzdug = str;
        this.zzedb = str2;
        this.zzedi = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.zzdug);
        hashMap.put("cachedSrc", this.zzedb);
        hashMap.put("totalDuration", Long.toString(this.zzedi));
        this.zzedf.zza("onPrecacheEvent", hashMap);
    }
}
