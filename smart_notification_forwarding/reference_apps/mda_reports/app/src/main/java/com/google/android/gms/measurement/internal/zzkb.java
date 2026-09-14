package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzkb extends zzkc {
    private boolean zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkb(zzke zzkeVar) {
        super(zzkeVar);
        this.b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaj() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzak() {
        if (!zzaj()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (this.zzb) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zze();
        this.b.e();
        this.zzb = true;
    }

    protected abstract boolean zze();
}
