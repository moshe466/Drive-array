package com.google.android.gms.gass;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzddn;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzh implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final Object lock = new Object();
    private boolean zzfvq = false;
    private boolean zzfvr = false;
    private final com.google.android.gms.gass.internal.zzd zzgso;
    private final zzddn zzgsp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(@NonNull Context context, @NonNull Looper looper, @NonNull zzddn zzddnVar) {
        this.zzgsp = zzddnVar;
        this.zzgso = new com.google.android.gms.gass.internal.zzd(context, looper, this, this);
    }

    private final void zzalu() {
        synchronized (this.lock) {
            if (this.zzgso.isConnected() || this.zzgso.isConnecting()) {
                this.zzgso.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        synchronized (this.lock) {
            if (!this.zzfvq) {
                this.zzfvq = true;
                this.zzgso.checkAvailabilityAndConnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.lock) {
            if (this.zzfvr) {
                return;
            }
            this.zzfvr = true;
            try {
                this.zzgso.zzaqp().zza(new com.google.android.gms.gass.internal.zzb(this.zzgsp.toByteArray()));
            } catch (Exception unused) {
            } catch (Throwable th) {
                zzalu();
                throw th;
            }
            zzalu();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
