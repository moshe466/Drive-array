package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import N2.f;
import a.AbstractC0228a;

/* loaded from: classes.dex */
public final class zzbj implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    public final String toString() {
        return AbstractC0008a.v(AbstractC0008a.y("avgExecutionTime: ", f.V(10, String.valueOf(this.zzb / this.zza)), " us| maxExecutionTime: ", f.V(10, String.valueOf(this.zzc)), " us| totalTime: "), f.V(10, String.valueOf(this.zzb)), " us| #Usages: ", f.V(5, String.valueOf(this.zza)));
    }

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzbj zzbjVar) {
        return AbstractC0228a.d(Long.valueOf(this.zzb), Long.valueOf(zzbjVar.zzb));
    }

    public final int zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final void zze(long j2) {
        this.zzc = j2;
    }

    public final void zzf(long j2) {
        this.zzb = j2;
    }

    public final void zzg(int i) {
        this.zza = i;
    }
}
