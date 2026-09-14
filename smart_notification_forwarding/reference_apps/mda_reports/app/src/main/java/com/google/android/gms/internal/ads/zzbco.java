package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbco implements Runnable {
    private final /* synthetic */ String zzdug;
    private final /* synthetic */ String zzedb;
    private final /* synthetic */ int zzedc;
    private final /* synthetic */ int zzedd;
    private final /* synthetic */ boolean zzede;
    private final /* synthetic */ zzbcn zzedf;
    private final /* synthetic */ long zzedh;
    private final /* synthetic */ long zzedi;
    private final /* synthetic */ int zzedj;
    private final /* synthetic */ int zzedk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbco(zzbcn zzbcnVar, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.zzedf = zzbcnVar;
        this.zzdug = str;
        this.zzedb = str2;
        this.zzedc = i;
        this.zzedd = i2;
        this.zzedh = j;
        this.zzedi = j2;
        this.zzede = z;
        this.zzedj = i3;
        this.zzedk = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.zzdug);
        hashMap.put("cachedSrc", this.zzedb);
        hashMap.put("bytesLoaded", Integer.toString(this.zzedc));
        hashMap.put("totalBytes", Integer.toString(this.zzedd));
        hashMap.put("bufferedDuration", Long.toString(this.zzedh));
        hashMap.put("totalDuration", Long.toString(this.zzedi));
        hashMap.put("cacheReady", this.zzede ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzedj));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzedk));
        this.zzedf.zza("onPrecacheEvent", hashMap);
    }
}
