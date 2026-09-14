package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzgr implements zzgt {
    protected final zzga a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgr(zzga zzgaVar) {
        Preconditions.checkNotNull(zzgaVar);
        this.a = zzgaVar;
    }

    public void zza() {
        this.a.d();
    }

    public void zzb() {
        this.a.c();
    }

    public void zzc() {
        this.a.zzq().zzc();
    }

    public void zzd() {
        this.a.zzq().zzd();
    }

    public zzah zzl() {
        return this.a.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public Clock zzm() {
        return this.a.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public Context zzn() {
        return this.a.zzn();
    }

    public zzeu zzo() {
        return this.a.zzj();
    }

    public zzkm zzp() {
        return this.a.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public zzft zzq() {
        return this.a.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public zzew zzr() {
        return this.a.zzr();
    }

    public zzff zzs() {
        return this.a.zzc();
    }

    public zzx zzt() {
        return this.a.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public zzw zzu() {
        return this.a.zzu();
    }
}
