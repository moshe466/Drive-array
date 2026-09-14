package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes.dex */
final class ka implements Iterator<String> {

    /* renamed from: f, reason: collision with root package name */
    private Iterator<String> f5433f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ ia f5434g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ka(ia iaVar) {
        e8 e8Var;
        this.f5434g = iaVar;
        e8Var = iaVar.f5390f;
        this.f5433f = e8Var.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5433f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f5433f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
