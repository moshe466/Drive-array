package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

/* loaded from: classes.dex */
final class la implements ListIterator<String> {

    /* renamed from: f, reason: collision with root package name */
    private ListIterator<String> f5462f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f5463g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ ia f5464h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public la(ia iaVar, int i10) {
        e8 e8Var;
        this.f5464h = iaVar;
        this.f5463g = i10;
        e8Var = iaVar.f5390f;
        this.f5462f = e8Var.listIterator(i10);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f5462f.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f5462f.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f5462f.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5462f.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f5462f.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5462f.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
