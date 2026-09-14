package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class t4<E> extends k4<E> implements Set<E> {

    /* renamed from: g, reason: collision with root package name */
    @NullableDecl
    private transient o4<E> f5615g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i10) {
        int max = Math.max(i10, 2);
        if (max >= 751619276) {
            n3.f(max < 1073741824, "collection too large");
            return 1073741824;
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * 0.7d < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof t4) && v() && ((t4) obj).v() && hashCode() != obj.hashCode()) {
            return false;
        }
        return i5.b(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return i5.a(this);
    }

    @Override // com.google.android.gms.internal.measurement.k4, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.measurement.k4
    public o4<E> s() {
        o4<E> o4Var = this.f5615g;
        if (o4Var != null) {
            return o4Var;
        }
        o4<E> w10 = w();
        this.f5615g = w10;
        return w10;
    }

    boolean v() {
        return false;
    }

    o4<E> w() {
        return o4.w(toArray());
    }
}
