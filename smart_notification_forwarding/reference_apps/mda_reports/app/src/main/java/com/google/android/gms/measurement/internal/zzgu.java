package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzgu extends zzgr {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgu(zzga zzgaVar) {
        super(zzgaVar);
        this.a.a(this);
    }

    protected void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaa() {
        if (!zzz()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzab() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zze()) {
            return;
        }
        this.a.e();
        this.zza = true;
    }

    public final void zzac() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        a();
        this.a.e();
        this.zza = true;
    }

    protected abstract boolean zze();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzz() {
        return this.zza;
    }
}
