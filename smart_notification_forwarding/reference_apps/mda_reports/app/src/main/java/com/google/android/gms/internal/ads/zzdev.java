package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class zzdev<E> {
    public zzdev<E> zza(Iterator<? extends E> it) {
        while (it.hasNext()) {
            zzae(it.next());
        }
        return this;
    }

    public abstract zzdev<E> zzae(E e);

    public zzdev<E> zze(Iterable<? extends E> iterable) {
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            zzae(it.next());
        }
        return this;
    }
}
