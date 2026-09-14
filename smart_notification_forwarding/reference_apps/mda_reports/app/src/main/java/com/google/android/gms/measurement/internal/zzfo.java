package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;

/* loaded from: classes.dex */
public final class zzfo implements ServiceConnection {
    final /* synthetic */ zzfl a;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfo(zzfl zzflVar, String str) {
        this.a = zzflVar;
        this.zzb = str;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.a.a.zzr().zzi().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzd zza = com.google.android.gms.internal.measurement.zzg.zza(iBinder);
            if (zza == null) {
                this.a.a.zzr().zzi().zza("Install Referrer Service implementation was not found");
            } else {
                this.a.a.zzr().zzv().zza("Install Referrer Service connected");
                this.a.a.zzq().zza(new zzfn(this, zza, this));
            }
        } catch (Exception e) {
            this.a.a.zzr().zzi().zza("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.a.zzr().zzv().zza("Install Referrer Service disconnected");
    }
}
