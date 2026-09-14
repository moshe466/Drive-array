package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements Iterator<String> {

    /* renamed from: f, reason: collision with root package name */
    private Iterator<String> f6265f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ p f6266g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p pVar) {
        Bundle bundle;
        this.f6266g = pVar;
        bundle = pVar.f6302f;
        this.f6265f = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6265f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f6265f.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
