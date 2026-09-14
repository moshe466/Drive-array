package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
final class y4<T> extends k5<T> {

    /* renamed from: f, reason: collision with root package name */
    private boolean f5714f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Object f5715g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y4(Object obj) {
        this.f5715g = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f5714f;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.f5714f) {
            throw new NoSuchElementException();
        }
        this.f5714f = true;
        return (T) this.f5715g;
    }
}
