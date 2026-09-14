package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzhr {
    private final zzddu zzaee;
    private final zzho zzahg;

    public zzhr(zzddu zzdduVar, zzho zzhoVar) {
        this.zzaee = zzhoVar != null ? (zzddu) zzoc.checkNotNull(zzdduVar) : null;
        this.zzahg = zzhoVar;
    }

    public final void zzb(int i, long j, long j2) {
        if (this.zzahg != null) {
            this.zzaee.post(new zzhv(this, i, j, j2));
        }
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzahg != null) {
            this.zzaee.post(new zzht(this, str, j, j2));
        }
    }

    public final void zzc(zzgw zzgwVar) {
        if (this.zzahg != null) {
            this.zzaee.post(new zzhs(this, zzgwVar));
        }
    }

    public final void zzc(zzit zzitVar) {
        if (this.zzahg != null) {
            this.zzaee.post(new zzhq(this, zzitVar));
        }
    }

    public final void zzd(zzit zzitVar) {
        if (this.zzahg != null) {
            this.zzaee.post(new zzhu(this, zzitVar));
        }
    }

    public final void zzs(int i) {
        if (this.zzahg != null) {
            this.zzaee.post(new zzhx(this, i));
        }
    }
}
