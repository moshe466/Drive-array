package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzkc extends zzgr implements zzgt {
    protected final zzke b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkc(zzke zzkeVar) {
        super(zzkeVar.f());
        Preconditions.checkNotNull(zzkeVar);
        this.b = zzkeVar;
    }

    public zzn e_() {
        return this.b.zzf();
    }

    public zzki zzg() {
        return this.b.zzh();
    }

    public zzac zzi() {
        return this.b.zze();
    }

    public zzfu zzj() {
        return this.b.zzc();
    }
}
