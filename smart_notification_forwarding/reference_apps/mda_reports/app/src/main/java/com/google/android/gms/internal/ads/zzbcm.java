package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* loaded from: classes.dex */
final class zzbcm implements Runnable {
    private final /* synthetic */ String zzdug;
    private final /* synthetic */ String zzedb;
    private final /* synthetic */ int zzedc;
    private final /* synthetic */ int zzedd;
    private final /* synthetic */ boolean zzede = false;
    private final /* synthetic */ zzbcn zzedf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcm(zzbcn zzbcnVar, String str, String str2, int i, int i2, boolean z) {
        this.zzedf = zzbcnVar;
        this.zzdug = str;
        this.zzedb = str2;
        this.zzedc = i;
        this.zzedd = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.zzdug);
        hashMap.put("cachedSrc", this.zzedb);
        hashMap.put("bytesLoaded", Integer.toString(this.zzedc));
        hashMap.put("totalBytes", Integer.toString(this.zzedd));
        hashMap.put("cacheReady", this.zzede ? "1" : "0");
        this.zzedf.zza("onPrecacheEvent", hashMap);
    }
}
