package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes.dex */
class zzdes<E> extends zzdev<E> {
    Object[] a;
    int b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdes(int i) {
        zzdeo.a(i, "initialCapacity");
        this.a = new Object[i];
        this.b = 0;
    }

    private final void zzdw(int i) {
        Object[] objArr = this.a;
        if (objArr.length >= i) {
            if (this.c) {
                this.a = (Object[]) objArr.clone();
                this.c = false;
                return;
            }
            return;
        }
        int length = objArr.length;
        if (i < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int i2 = length + (length >> 1) + 1;
        if (i2 < i) {
            i2 = Integer.highestOneBit(i - 1) << 1;
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        this.a = Arrays.copyOf(objArr, i2);
        this.c = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdev
    /* renamed from: zzad, reason: merged with bridge method [inline-methods] */
    public zzdes<E> zzae(E e) {
        zzdei.checkNotNull(e);
        zzdw(this.b + 1);
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = e;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdev
    public zzdev<E> zze(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzdw(this.b + collection.size());
            if (collection instanceof zzdet) {
                this.b = ((zzdet) collection).a(this.a, this.b);
                return this;
            }
        }
        super.zze(iterable);
        return this;
    }
}
