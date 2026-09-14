package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbct implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzdug;
    private final /* synthetic */ String zzedb;
    private final /* synthetic */ zzbcn zzedf;
    private final /* synthetic */ String zzedl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbct(zzbcn zzbcnVar, String str, String str2, String str3, String str4) {
        this.zzedf = zzbcnVar;
        this.zzdug = str;
        this.zzedb = str2;
        this.zzedl = str3;
        this.val$message = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String zzfk;
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        hashMap.put("src", this.zzdug);
        if (!TextUtils.isEmpty(this.zzedb)) {
            hashMap.put("cachedSrc", this.zzedb);
        }
        zzbcn zzbcnVar = this.zzedf;
        zzfk = zzbcn.zzfk(this.zzedl);
        hashMap.put("type", zzfk);
        hashMap.put("reason", this.zzedl);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put(SettingsJsonConstants.PROMPT_MESSAGE_KEY, this.val$message);
        }
        this.zzedf.zza("onPrecacheEvent", hashMap);
    }
}
