package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
final class zzdfd<T> extends zzdfp<T> {
    private boolean zzgur;
    private final /* synthetic */ Object zzgus;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfd(Object obj) {
        this.zzgus = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzgur;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.zzgur) {
            throw new NoSuchElementException();
        }
        this.zzgur = true;
        return (T) this.zzgus;
    }
}
