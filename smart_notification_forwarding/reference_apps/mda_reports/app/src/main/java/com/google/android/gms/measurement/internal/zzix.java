package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzix implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzm zze;
    private final /* synthetic */ zzij zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzix(zzij zzijVar, AtomicReference atomicReference, String str, String str2, String str3, zzm zzmVar) {
        this.zzf = zzijVar;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzeo zzeoVar;
        AtomicReference atomicReference2;
        List<zzv> zza;
        synchronized (this.zza) {
            try {
                try {
                    zzeoVar = this.zzf.zzb;
                } catch (RemoteException e) {
                    this.zzf.zzr().zzf().zza("Failed to get conditional properties", zzew.zza(this.zzb), this.zzc, e);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                }
                if (zzeoVar == null) {
                    this.zzf.zzr().zzf().zza("Failed to get conditional properties", zzew.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    atomicReference2 = this.zza;
                    zza = zzeoVar.zza(this.zzc, this.zzd, this.zze);
                } else {
                    atomicReference2 = this.zza;
                    zza = zzeoVar.zza(this.zzb, this.zzc, this.zzd);
                }
                atomicReference2.set(zza);
                this.zzf.zzaj();
                atomicReference = this.zza;
                atomicReference.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
