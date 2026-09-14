package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzjb implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzij a;
    private volatile boolean zzb;
    private volatile zzet zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjb(zzij zzijVar) {
        this.a = zzijVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zzjb zzjbVar, boolean z) {
        zzjbVar.zzb = false;
        return false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnected(@Nullable Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.a.zzq().zza(new zzjg(this, this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzew zzd = this.a.a.zzd();
        if (zzd != null) {
            zzd.zzi().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.a.zzq().zza(new zzji(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.a.zzr().zzw().zza("Service connection suspended");
        this.a.zzq().zza(new zzjf(this));
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzjb zzjbVar;
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zzb = false;
                this.a.zzr().zzf().zza("Service connected with null binder");
                return;
            }
            zzeo zzeoVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        zzeoVar = queryLocalInterface instanceof zzeo ? (zzeo) queryLocalInterface : new zzeq(iBinder);
                    }
                    this.a.zzr().zzx().zza("Bound to IMeasurementService interface");
                } else {
                    this.a.zzr().zzf().zza("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.a.zzr().zzf().zza("Service connect failed to get IMeasurementService");
            }
            if (zzeoVar == null) {
                this.zzb = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    Context zzn = this.a.zzn();
                    zzjbVar = this.a.zza;
                    connectionTracker.unbindService(zzn, zzjbVar);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.a.zzq().zza(new zzje(this, zzeoVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.a.zzr().zzw().zza("Service disconnected");
        this.a.zzq().zza(new zzjd(this, componentName));
    }

    @WorkerThread
    public final void zza() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    @WorkerThread
    public final void zza(Intent intent) {
        zzjb zzjbVar;
        this.a.zzd();
        Context zzn = this.a.zzn();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.a.zzr().zzx().zza("Connection attempt already in progress");
                return;
            }
            this.a.zzr().zzx().zza("Using local app measurement service");
            this.zzb = true;
            zzjbVar = this.a.zza;
            connectionTracker.bindService(zzn, intent, zzjbVar, 129);
        }
    }

    @WorkerThread
    public final void zzb() {
        this.a.zzd();
        Context zzn = this.a.zzn();
        synchronized (this) {
            if (this.zzb) {
                this.a.zzr().zzx().zza("Connection attempt already in progress");
                return;
            }
            if (this.zzc != null && (this.zzc.isConnecting() || this.zzc.isConnected())) {
                this.a.zzr().zzx().zza("Already awaiting connection attempt");
                return;
            }
            this.zzc = new zzet(zzn, Looper.getMainLooper(), this, this);
            this.a.zzr().zzx().zza("Connecting to remote service");
            this.zzb = true;
            this.zzc.checkAvailabilityAndConnect();
        }
    }
}
