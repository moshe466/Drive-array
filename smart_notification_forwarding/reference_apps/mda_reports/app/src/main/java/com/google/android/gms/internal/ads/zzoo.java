package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class zzoo implements zzog {
    private boolean started;
    private zzhc zzadi = zzhc.zzagb;
    private long zzbgs;
    private long zzbgt;

    public final void start() {
        if (this.started) {
            return;
        }
        this.zzbgt = SystemClock.elapsedRealtime();
        this.started = true;
    }

    public final void stop() {
        if (this.started) {
            zzel(zzfp());
            this.started = false;
        }
    }

    public final void zza(zzog zzogVar) {
        zzel(zzogVar.zzfp());
        this.zzadi = zzogVar.zzfi();
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final zzhc zzb(zzhc zzhcVar) {
        if (this.started) {
            zzel(zzfp());
        }
        this.zzadi = zzhcVar;
        return zzhcVar;
    }

    public final void zzel(long j) {
        this.zzbgs = j;
        if (this.started) {
            this.zzbgt = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final zzhc zzfi() {
        return this.zzadi;
    }

    @Override // com.google.android.gms.internal.ads.zzog
    public final long zzfp() {
        long j = this.zzbgs;
        if (!this.started) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbgt;
        zzhc zzhcVar = this.zzadi;
        return j + (zzhcVar.zzagc == 1.0f ? zzgi.zzdn(elapsedRealtime) : zzhcVar.zzdu(elapsedRealtime));
    }
}
