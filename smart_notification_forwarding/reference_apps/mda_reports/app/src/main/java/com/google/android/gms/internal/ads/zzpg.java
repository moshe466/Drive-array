package com.google.android.gms.internal.ads;

import android.view.Surface;

/* loaded from: classes.dex */
public final class zzpg {
    private final zzddu zzaee;
    private final zzpd zzbjh;

    public zzpg(zzddu zzdduVar, zzpd zzpdVar) {
        this.zzaee = zzpdVar != null ? (zzddu) zzoc.checkNotNull(zzdduVar) : null;
        this.zzbjh = zzpdVar;
    }

    public final void zzb(int i, int i2, int i3, float f) {
        if (this.zzbjh != null) {
            this.zzaee.post(new zzpj(this, i, i2, i3, f));
        }
    }

    public final void zzb(Surface surface) {
        if (this.zzbjh != null) {
            this.zzaee.post(new zzpm(this, surface));
        }
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzbjh != null) {
            this.zzaee.post(new zzpi(this, str, j, j2));
        }
    }

    public final void zzc(zzgw zzgwVar) {
        if (this.zzbjh != null) {
            this.zzaee.post(new zzph(this, zzgwVar));
        }
    }

    public final void zzc(zzit zzitVar) {
        if (this.zzbjh != null) {
            this.zzaee.post(new zzpf(this, zzitVar));
        }
    }

    public final void zzd(zzit zzitVar) {
        if (this.zzbjh != null) {
            this.zzaee.post(new zzpl(this, zzitVar));
        }
    }

    public final void zzf(int i, long j) {
        if (this.zzbjh != null) {
            this.zzaee.post(new zzpk(this, i, j));
        }
    }
}
