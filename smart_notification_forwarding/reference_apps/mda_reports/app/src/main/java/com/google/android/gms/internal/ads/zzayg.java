package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzayg {
    private boolean zzdvb;
    private Context zzyv;
    private boolean zzxx = false;

    @GuardedBy("this")
    private final Map<BroadcastReceiver, IntentFilter> zzdva = new WeakHashMap();

    @GuardedBy("this")
    private final BroadcastReceiver zzduz = new zzayj(this);

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzc(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.zzdva.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                arrayList.add(entry.getKey());
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((BroadcastReceiver) obj).onReceive(context, intent);
        }
    }

    public final synchronized void initialize(Context context) {
        if (this.zzxx) {
            return;
        }
        this.zzyv = context.getApplicationContext();
        if (this.zzyv == null) {
            this.zzyv = context;
        }
        zzzn.initialize(this.zzyv);
        this.zzdvb = ((Boolean) zzve.zzoy().zzd(zzzn.zzcmg)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.zzyv.registerReceiver(this.zzduz, intentFilter);
        this.zzxx = true;
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzdvb) {
            this.zzdva.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzdvb) {
            this.zzdva.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
