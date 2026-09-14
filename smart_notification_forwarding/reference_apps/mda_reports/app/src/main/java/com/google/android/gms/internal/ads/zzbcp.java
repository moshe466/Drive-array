package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbcp implements Runnable {
    private final /* synthetic */ String zzdug;
    private final /* synthetic */ String zzedb;
    private final /* synthetic */ boolean zzede;
    private final /* synthetic */ zzbcn zzedf;
    private final /* synthetic */ long zzedh;
    private final /* synthetic */ long zzedi;
    private final /* synthetic */ int zzedj;
    private final /* synthetic */ int zzedk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcp(zzbcn zzbcnVar, String str, String str2, long j, long j2, boolean z, int i, int i2) {
        this.zzedf = zzbcnVar;
        this.zzdug = str;
        this.zzedb = str2;
        this.zzedh = j;
        this.zzedi = j2;
        this.zzede = z;
        this.zzedj = i;
        this.zzedk = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.zzdug);
        hashMap.put("cachedSrc", this.zzedb);
        hashMap.put("bufferedDuration", Long.toString(this.zzedh));
        hashMap.put("totalDuration", Long.toString(this.zzedi));
        hashMap.put("cacheReady", this.zzede ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzedj));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzedk));
        this.zzedf.zza("onPrecacheEvent", hashMap);
    }
}
