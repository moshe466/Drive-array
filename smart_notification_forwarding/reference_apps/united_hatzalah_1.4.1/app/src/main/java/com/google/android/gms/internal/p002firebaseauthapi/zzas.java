package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class zzas<E> extends zzai<E> implements Set<E> {
    private transient zzaj<E> zza;

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return zzax.zza(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzax.zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public zzaj<E> zzc() {
        zzaj<E> zzajVar = this.zza;
        if (zzajVar == null) {
            zzaj<E> zzg = zzg();
            this.zza = zzg;
            return zzg;
        }
        return zzajVar;
    }

    public zzaj<E> zzg() {
        return zzaj.zza(toArray());
    }
}
