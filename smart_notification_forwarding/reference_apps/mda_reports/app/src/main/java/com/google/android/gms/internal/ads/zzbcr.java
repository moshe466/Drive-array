package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbcr implements Runnable {
    private final /* synthetic */ String zzdug;
    private final /* synthetic */ String zzedb;
    private final /* synthetic */ int zzedd;
    private final /* synthetic */ zzbcn zzedf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcr(zzbcn zzbcnVar, String str, String str2, int i) {
        this.zzedf = zzbcnVar;
        this.zzdug = str;
        this.zzedb = str2;
        this.zzedd = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.zzdug);
        hashMap.put("cachedSrc", this.zzedb);
        hashMap.put("totalBytes", Integer.toString(this.zzedd));
        this.zzedf.zza("onPrecacheEvent", hashMap);
    }
}
