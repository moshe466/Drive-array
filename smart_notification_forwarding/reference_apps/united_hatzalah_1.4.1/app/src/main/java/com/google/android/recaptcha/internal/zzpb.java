package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzpb implements Iterator {
    final /* synthetic */ zzpe zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzpb(zzpe zzpeVar, zzpd zzpdVar) {
        this.zza = zzpeVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = zzpe.zzh(this.zza).entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzpe zzpeVar = this.zza;
        if (i < zzpe.zzb(zzpeVar)) {
            return true;
        }
        if (!zzpe.zzh(zzpeVar).isEmpty() && zza().hasNext()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzpe zzpeVar = this.zza;
        if (i < zzpe.zzb(zzpeVar)) {
            return (zzpa) zzpe.zzk(zzpeVar)[i];
        }
        return (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            zzpe.zzi(this.zza);
            int i = this.zzb;
            zzpe zzpeVar = this.zza;
            if (i < zzpe.zzb(zzpeVar)) {
                this.zzb = i - 1;
                zzpe.zze(zzpeVar, i);
                return;
            } else {
                zza().remove();
                return;
            }
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
