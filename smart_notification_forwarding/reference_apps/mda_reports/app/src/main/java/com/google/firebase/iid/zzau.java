package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
/* loaded from: classes2.dex */
final class zzau extends BroadcastReceiver {

    @Nullable
    private zzav zza;

    public zzau(zzav zzavVar) {
        this.zza = zzavVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzav zzavVar = this.zza;
        if (zzavVar != null && zzavVar.b()) {
            if (FirebaseInstanceId.h()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.a(this.zza, 0L);
            this.zza.a().unregisterReceiver(this);
            this.zza = null;
        }
    }

    public final void zza() {
        if (FirebaseInstanceId.h()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.zza.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
