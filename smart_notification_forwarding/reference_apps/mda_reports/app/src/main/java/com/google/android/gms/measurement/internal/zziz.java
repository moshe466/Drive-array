package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zziz implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzm zzf;
    private final /* synthetic */ zzij zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziz(zzij zzijVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzm zzmVar) {
        this.zzg = zzijVar;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzeo zzeoVar;
        AtomicReference atomicReference2;
        List<zzkl> zza;
        synchronized (this.zza) {
            try {
                try {
                    zzeoVar = this.zzg.zzb;
                } catch (RemoteException e) {
                    this.zzg.zzr().zzf().zza("Failed to get user properties", zzew.zza(this.zzb), this.zzc, e);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                }
                if (zzeoVar == null) {
                    this.zzg.zzr().zzf().zza("Failed to get user properties", zzew.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    atomicReference2 = this.zza;
                    zza = zzeoVar.zza(this.zzc, this.zzd, this.zze, this.zzf);
                } else {
                    atomicReference2 = this.zza;
                    zza = zzeoVar.zza(this.zzb, this.zzc, this.zzd, this.zze);
                }
                atomicReference2.set(zza);
                this.zzg.zzaj();
                atomicReference = this.zza;
                atomicReference.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
