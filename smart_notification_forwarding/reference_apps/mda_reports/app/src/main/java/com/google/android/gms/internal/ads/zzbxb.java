package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* loaded from: classes.dex */
public final class zzbxb {
    zzadj a;
    zzadi b;
    zzadv c;
    zzadu d;
    zzahh e;
    final SimpleArrayMap<String, zzadp> f = new SimpleArrayMap<>();
    final SimpleArrayMap<String, zzado> g = new SimpleArrayMap<>();

    public final zzbxb zza(zzadu zzaduVar) {
        this.d = zzaduVar;
        return this;
    }

    public final zzbwz zzajw() {
        return new zzbwz(this);
    }

    public final zzbxb zzb(zzadi zzadiVar) {
        this.b = zzadiVar;
        return this;
    }

    public final zzbxb zzb(zzadj zzadjVar) {
        this.a = zzadjVar;
        return this;
    }

    public final zzbxb zzb(zzadv zzadvVar) {
        this.c = zzadvVar;
        return this;
    }

    public final zzbxb zzb(zzahh zzahhVar) {
        this.e = zzahhVar;
        return this;
    }

    public final zzbxb zzb(String str, zzadp zzadpVar, zzado zzadoVar) {
        this.f.put(str, zzadpVar);
        this.g.put(str, zzadoVar);
        return this;
    }
}
