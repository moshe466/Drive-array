package com.google.android.gms.internal.measurement;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f4<T> implements Iterator<T> {

    /* renamed from: f, reason: collision with root package name */
    private int f5305f;

    /* renamed from: g, reason: collision with root package name */
    private int f5306g;

    /* renamed from: h, reason: collision with root package name */
    private int f5307h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ y3 f5308i;

    private f4(y3 y3Var) {
        int i10;
        this.f5308i = y3Var;
        i10 = y3Var.f5709j;
        this.f5305f = i10;
        this.f5306g = y3Var.q();
        this.f5307h = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f4(y3 y3Var, b4 b4Var) {
        this(y3Var);
    }

    private final void c() {
        int i10;
        i10 = this.f5308i.f5709j;
        if (i10 != this.f5305f) {
            throw new ConcurrentModificationException();
        }
    }

    abstract T b(int i10);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f5306g >= 0;
    }

    @Override // java.util.Iterator
    public T next() {
        c();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f5306g;
        this.f5307h = i10;
        T b10 = b(i10);
        this.f5306g = this.f5308i.a(this.f5306g);
        return b10;
    }

    @Override // java.util.Iterator
    public void remove() {
        c();
        n3.h(this.f5307h >= 0, "no calls to next() since the last call to remove()");
        this.f5305f += 32;
        y3 y3Var = this.f5308i;
        y3Var.remove(y3Var.f5707h[this.f5307h]);
        this.f5306g = y3.h(this.f5306g, this.f5307h);
        this.f5307h = -1;
    }
}
